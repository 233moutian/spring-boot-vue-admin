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
@Transactional
@Rollback
public class BaseTest {
    @Autowired
    WebApplicationContext context;
    @Resource
    private JWTSetting jwtSetting;
    @Resource
    private RSAUtil rsaUtil;

    /*
     * 测试dao方法
     * */
    @Test
    public void getRole() throws Exception {
        System.out.println("test");
    }

}
