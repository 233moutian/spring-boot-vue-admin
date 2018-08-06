package com.zoctan.api.api.pay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jacky on 16/9/8.
 * sha256加密类
 */
public class Encrypt {

    public static String SHA256(String text)  {
        return SHA(text,"SHA-256");
    }

    private static String SHA(String text,String type) {
        String result=null;
        try {
            MessageDigest digest=MessageDigest.getInstance(type);
            byte[] bytes = digest.digest(text.getBytes());

            StringBuffer sb=new StringBuffer();
            for (int i=0;i<bytes.length;i++){

                String hex = Integer.toHexString(0xff & bytes[i]);
                if (hex.length()==1){
                    sb.append("0");
                }
                sb.append(hex);

            }
            result=sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;

    }


}
