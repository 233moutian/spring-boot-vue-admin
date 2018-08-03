package com.zoctan.api.api.pay;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jacky on 16/9/8.
 * http请求类
 */
public class HttpUtil {


    public static String makePostRequest(String url, RequestParam requestParam,String signKey){
        CloseableHttpClient client = HttpClients.createDefault();
        RequestConfig config=RequestConfig.custom().setConnectionRequestTimeout(Config.getConnectionTimeout()).
                setConnectTimeout(Config.getConnectionTimeout()).setSocketTimeout(Config.getReadTimeout()).build();

        HttpPost post=new HttpPost(url);
        post.setConfig(config);
        post.setEntity(MkEntity.mkEntity(requestParam,signKey));
        HttpEntity res=null;
        try {
            CloseableHttpResponse execute = client.execute(post);
            res = execute.getEntity();
          return   EntityUtils.toString(res);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                EntityUtils.consume(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }



}
