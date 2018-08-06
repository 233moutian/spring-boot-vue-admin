package com.zoctan.api;

import com.alibaba.fastjson.JSONObject;
import com.zoctan.api.api.RemitApi;
import com.zoctan.api.core.jwt.JWTSetting;
import com.zoctan.api.core.memcache.MemcacheClient;
import com.zoctan.api.util.RSAUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by zxw on 2018/8/6 0006.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@ContextConfiguration(locations = {"classpath:application-test.properties"})
@Transactional
@Rollback
public class OtherTest {
    @Autowired
    WebApplicationContext context;
    @Autowired
    MemcacheClient memcacheClient;
    @Resource
    private JWTSetting jwtSetting;
    @Resource
    private RSAUtil rsaUtil;

    @Test(timeout = 5000)
    public void test() throws Exception {
        System.out.println(memcacheClient);
    }

    /*
    * 请求参数加密与解密
    * */
    @Test(timeout = 5000)
    public void sign() throws Exception {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("money", "0.10");
        paramMap.put("createTime", "2018-08-01 16:35:15");
        paramMap.put("orderId", "Ijw6zgpKRh3OdCpHvBFKsfEnTGOxRKRBocCa3wfirgZJLJNhUVQhhIYqLTvPnCwV");
        paramMap.put("Qrcode", "aHR0cHM6Ly9lLmFiY2hpbmEuY29tL3FyY29kZS8jIS9xcmNvZGUvMDMwMi9PRE16T0RjNE9ESXhPREE0TURNd01UY3dNRE13TVRnPS9PRE16T0RjNE9ESXhNRE00T0RRME1ESTRPVUV4VTFBPS9PRE16T0RjNE9ESXhOVE16TWpnd01qZ3dNRGN4TURJMU5qWXhOZz09");
//        paramMap.put("ip", "127.0.0.0");

        RemitApi.signWithKey(paramMap, jwtSetting.getPrivateKey());
        System.out.println(JSONObject.toJSONString(paramMap));

        System.out.println(RemitApi.checkParams(paramMap, jwtSetting.getPublicKey()));

    }

    /*
    * 测试dao方法
    * */
    @Test(timeout = 5000)
    public void getRole() throws Exception {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("money", "0.10");
        paramMap.put("createTime", "2018-08-01 16:35:15");
        paramMap.put("orderId", "Ijw6zgpKRh3OdCpHvBFKsfEnTGOxRKRBocCa3wfirgZJLJNhUVQhhIYqLTvPnCwV");
        paramMap.put("Qrcode", "aHR0cHM6Ly9lLmFiY2hpbmEuY29tL3FyY29kZS8jIS9xcmNvZGUvMDMwMi9PRE16T0RjNE9ESXhPREE0TURNd01UY3dNRE13TVRnPS9PRE16T0RjNE9ESXhNRE00T0RRME1ESTRPVUV4VTFBPS9PRE16T0RjNE9ESXhOVE16TWpnd01qZ3dNRGN4TURJMU5qWXhOZz09");
//        paramMap.put("ip", "127.0.0.0");

        RemitApi.signWithKey(paramMap, jwtSetting.getPrivateKey());
        System.out.println(JSONObject.toJSONString(paramMap));

        System.out.println(RemitApi.checkParams(paramMap, jwtSetting.getPublicKey()));

    }


}
