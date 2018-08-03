package com.zoctan.api.api.pay;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by jacky on 2017/8/5.
 */
public class TestDownload {


    public static void main(String[] args) {
     /*   try {

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            main1(args);
            main2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://ip/m/service/download/bill");
        httpPost.setConfig(RequestConfig.DEFAULT);

        List<NameValuePair> valuePairs=new ArrayList<NameValuePair>();
        valuePairs.add(new BasicNameValuePair("version","1.1"));
        valuePairs.add(new BasicNameValuePair("merchantId","100001"));
        valuePairs.add(new BasicNameValuePair("timeRange","20170801/20170801"));

        String s = Encrypt.SHA256("10000120170801/201708011.11234512345");
        System.out.println(s);
        valuePairs.add(new BasicNameValuePair("sign",s));

        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, Charset.forName("UTF-8"));

        httpPost.setEntity(urlEncodedFormEntity);

        CloseableHttpResponse execute = client.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        StatusLine statusLine = execute.getStatusLine();
        System.out.println(statusLine.getStatusCode());
        if (statusLine.getStatusCode()==500){
            String s1 = EntityUtils.toString(entity);
            System.out.println(s1);
        }
        else {
            Header contentType = entity.getContentType();
            System.out.println(contentType.getName() + contentType.getValue());

            entity.writeTo(new FileOutputStream(new File(System.currentTimeMillis()+".zip")));

            EntityUtils.consume(entity);
        }
    }


    static void  main2() throws IOException {

        ZipFile zipFile=new ZipFile("1501989596321.zip");

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("1501989596321.zip"));

        byte[] buffer=new byte[2048];
        ZipEntry zipEntry;
        while ((zipEntry=zipInputStream.getNextEntry())!=null){

                if (zipEntry.isDirectory()){

                }else{
                    System.out.println("file:"+zipEntry.getName()+","+zipEntry.getSize()+"bytes");
                    long size=zipEntry.getSize();
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line=null;
                    while ((line=bufferedReader.readLine())!=null){
                    //    System.out.println("this is "+line);
                        String[] split = line.split(",");
                        for (String str:split){
                            System.out.print(str+"\t");
                        }
                        System.out.println();


                    }
                    bufferedReader.close();
                    inputStream.close();

                }


        }

        zipInputStream.close();


    }

}
