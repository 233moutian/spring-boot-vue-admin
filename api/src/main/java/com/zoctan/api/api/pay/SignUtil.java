package com.zoctan.api.api.pay;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by jacky on 16/9/8.
 * 签名类
 */
public class SignUtil {

    public static String signFromObject(RequestParam request,String signKey)  {
        request.setSign("");
        Class<? extends RequestParam> clazz = request.getClass();
        Map<String, String> maps = new HashMap<String, String>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object object = null;
            try {
                object = field.get(request);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (object != null && !"".equals(object.toString().trim())) {
                maps.put(field.getName(), object.toString());
            }
        }

        if(maps.size()!=0){

            Set<String> strings = maps.keySet();
            String[] keys = strings.toArray(new String[strings.size()]);
            Arrays.sort(keys);
            StringBuffer sb=new StringBuffer();
            for (String key:keys){
                sb.append(maps.get(key));

            }
            String line=sb.toString()+signKey;
            return Encrypt.SHA256(line);
        }
        return null;
    }

}
