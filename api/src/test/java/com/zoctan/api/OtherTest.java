package com.zoctan.api;

import com.zoctan.api.core.jwt.JWTSetting;
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
    @Resource
    private JWTSetting jwtSetting;
    @Resource
    private RSAUtil rsaUtil;



    /*
    * 测试dao方法
    * */
    @Test(timeout = 5000)
    public void getRole() throws Exception {
//        System.out.println(JedisUtil.getInstance().STRINGS.get("test"));
//        System.out.println(JedisUtil.getInstance().STRINGS.setEx("test02", 1010101, "test02!!!"));
        String[] str=context.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("..."+string);
        }
    }

}
