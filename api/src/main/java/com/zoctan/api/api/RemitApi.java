package com.zoctan.api.api;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jacky on 2017/12/15.
 *
 * update by 233moutian on 2018/8/6
 */
public class RemitApi {

     private static Logger logger = LoggerFactory.getLogger(RemitApi.class);

    /**
     * 读取私钥信息
     * @param priKey
     * @return
     * @throws Exception
     * PS: 233moutian将原来的方法注释掉了,改为本地的新方法,以解决秘钥过长的问题.
     */
     public static PrivateKey readPriKey(String priKey) throws Exception{
       /*  try {

             byte[] bytes = priKey.getBytes();
             byte[] keyBytes = Base64.decodeBase64(bytes);
             PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
             KeyFactory keyFactory = KeyFactory.getInstance("RSA");
             return keyFactory.generatePrivate(pkcs8EncodedKeySpec);

         } catch (Exception e){
             logger.error("加载秘钥私钥失败,原因为{}",e.getMessage());
             throw e;
         }
*/
         try {
             final ResourceLoader loader = new DefaultResourceLoader();
             final Resource resource = loader.getResource(priKey);
             final File f = resource.getFile();
             final FileInputStream fis = new FileInputStream(f);
             final DataInputStream dis = new DataInputStream(fis);
             final byte[] keyBytes = new byte[(int) f.length()];
             dis.readFully(keyBytes);
             dis.close();
             final String temp = new String(keyBytes);
//             System.out.println("KeyPEM : " + temp);
             final byte[] decoded = Base64.decodeBase64(keyBytes);
             final PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
             final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
             return keyFactory.generatePrivate(spec);
         } catch (final Exception e) {
             logger.error("加载秘钥私钥失败,原因为{}",e.getMessage());
             return null;
         }

     }

    /**
     * 读取公钥信息
     * @param pubKey
     * @return
     * @throws Exception
     * PS: 233moutian将原来的方法注释掉了,改为本地的新方法,以解决秘钥过长的问题.
     */
     public static PublicKey readPubKey(String pubKey) throws Exception{
         try {
             final ResourceLoader loader = new DefaultResourceLoader();
             final Resource resource = loader.getResource(pubKey);
             final File f = resource.getFile();
             final FileInputStream fis = new FileInputStream(f);
             final DataInputStream dis = new DataInputStream(fis);
             final byte[] keyBytes = new byte[(int) f.length()];
             dis.readFully(keyBytes);
             dis.close();
             final String temp = new String(keyBytes);
//             System.out.println("KeyPEM : " + temp);
             final byte[] decoded = Base64.decodeBase64(temp);
             final X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
             final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
             return keyFactory.generatePublic(spec);
         } catch (final Exception e) {
             logger.error("加载公钥信息出错,原因为{}",e.getMessage());
             return null;
         }
         /*
        try {
            byte[] bytes = pubKey.getBytes("utf-8");
            byte[] keyBytes = Base64.decodeBase64(bytes);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(x509EncodedKeySpec);
        }catch (Exception e){
            logger.error("加载公钥信息出错,原因为{}",e.getMessage());
            throw e;
        }*/
     }


    /**
     * 用私钥签名
     * explain : 首先new一个sortedMap,这个map生成的时候会自动排序的,然后将这个map转成一个把所有键值对以“&”字符连接起来的字符串,
     * 然后将这个字符串进行SHA1withRSA签名获得byte[] sign, 然后再进行String result = Base64.encodeBase64String(sign);再将此字符串放入原来的params中.
     * @param params
     * @param keyStr
     * @throws Exception
     */
    public static void signWithKey(Map<String,String> params, String keyStr) throws Exception{
        TreeMap<String, String> sortedMap = new TreeMap<String, String>(params);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> param:sortedMap.entrySet()){
            String value = param.getValue();
            if (!isBlank(value)){
                sb.append("&").append(param.getKey()).append("=").append(param.getValue());
            }
        }
        try {
            byte[] bytes = sb.substring(1).getBytes("UTF-8");
            Signature sha1WithRSA = Signature.getInstance("SHA1withRSA");

            sha1WithRSA.initSign(readPriKey(keyStr));

            sha1WithRSA.update(bytes);
            byte[] sign = sha1WithRSA.sign();
            String result = Base64.encodeBase64String(sign);
            params.put("sign",result);
        } catch (Exception e) {
                logger.error("签名字符串信息出错,原因为{}",e.getMessage());
            throw e;
        }
    }

    public static String request(Map<String, String> params, String requestUrl, String prikey){
        return request(params, requestUrl, prikey, "UTF-8", 10000, 10000);
    }

    /**
     * 发起支付请求
     * @param params
     * @param requestUrl
     * @param prikey
     */
    public static String request(Map<String, String> params, String requestUrl, String prikey, String charset, int connectionTimeout, int readTimeout){
        try {
            signWithKey(params,prikey);  //首先进行签名,如果签名失败,则抛出错误信息
//            Json make = Json.make(params);
            String jsonStr = JSON.toJSONString(params); // 转成json
            // 将上⾯json串进⾏base64编码，再urlcoder两次，并拼上“sendData=”，即为最终发送的数据
            String str = Base64.encodeBase64String(jsonStr.toString().getBytes("utf-8"));
            str = URLEncoder.encode(str, "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            String finalStr = "sendData="+str;
            String response = postRequest(finalStr, requestUrl);
            return response;
        } catch (Exception e) {
            logger.error("代付请求发起失败,原因为{}",e.getMessage());
            return null;
        }
    }


    public static String postRequest(String param, String requestUrl){
       return postRequest(param, requestUrl, "utf-8", 10000,10000);
    }

    public static String postRequest(String param,String requestUrl, String charset, int connectionTimeout, int readTimeout){
        HttpURLConnection urlConnection=null;
        try {
            URL url = new URL(requestUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(connectionTimeout);
            urlConnection.setReadTimeout(readTimeout);
            urlConnection.connect();  //建立连接

            OutputStream outputStream = urlConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(param);  //发送信息
            outputStreamWriter.flush();
            outputStreamWriter.close();

            InputStream inputStream = urlConnection.getInputStream();  //获取返回信息
            byte[] buffer =new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int line;
            while ((line=bis.read(buffer))!= -1){
                    byteArrayOutputStream.write(buffer,0,line);
            }
            return byteArrayOutputStream.toString(charset);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 用于处理返回字符串信息..
     * @param finalStr
     * @return
     */
    public static Map<String, String> handleResponse(String finalStr){
        if (logger.isDebugEnabled()) {
            logger.debug("handleResponse, finalStr:{}", finalStr);
        }
//        assert finalStr.startsWith("sendData=");
        String responseStr = finalStr/*.substring(9)*/;
//        byte[] bytes = Base64.decodeBase64(substring.replaceAll("#", "+"));
//        try {
//             responseStr = new String(bytes, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            logger.error("Exception occurred while RemitApi.handleResponse", e);
//        }
//        Json read = Json.read(responseStr);
//        return read.asMap();

        return JSON.parseObject(responseStr, Map.class);
//        return JSON.parseObject(responseStr, new TypeReference<Map<String, String>>(){});
    }

    /**
     * 请求响应码为SUCCESS，并且业务响应码为0时，表示接口功能调用成功
     * @param responseMap
     * @return
     */
    public static boolean isSuccess(Map<String, String> responseMap) {
        if (responseMap.containsKey("code") && responseMap.containsKey("resultCode")) {
            return responseMap.get("code").equals("SUCCESS") && responseMap.get("resultCode").equals("0");
        }

        return false;
    }

    /**
     * 用于返回信息的验签
     * @param params
     * @param pubKey
     * @return
     */
    public static boolean checkParams(Map<String, String> params, String pubKey){
        TreeMap<String, String> sortedMap = new TreeMap<String, String>(params);
        String sign = sortedMap.get("sign")+"";

        StringBuilder sb=new StringBuilder();
        for (Map.Entry<String, String> param:sortedMap.entrySet()){
            String key = param.getKey();
            // 对map⾥的key排除“sign”后从a到z的顺序排序，再把所有键值对以“&”字符连接起来（值为空的字段，请勿拼接）
            if (!"sign".equals(key)){
                if (!isBlank(String.valueOf(param.getValue()))) {
                    sb.append("&").append(key).append("=").append(String.valueOf(param.getValue()));
                }
            }
        }
//      使⽤去掉换⾏符的我⽅公钥和返回报⽂中sign字段的对拼接后的字符串进⾏SHA1WithRSA验签。
        try {
            byte[] bytes = Base64.decodeBase64(sign);
            byte[] resultBytes = sb.substring(1).getBytes("utf-8");
            Signature sha1WithRSA = Signature.getInstance("SHA1withRSA");
            sha1WithRSA.initVerify(readPubKey(pubKey));
            sha1WithRSA.update(resultBytes);
            return sha1WithRSA.verify(bytes);
        } catch (Exception e) {
            logger.error("验签结果失败,原因为{}",e.getMessage());
        }
        return false;
    }

    private static boolean isBlank(String str){
        return str==null || str.trim().length()==0;
    }

}
