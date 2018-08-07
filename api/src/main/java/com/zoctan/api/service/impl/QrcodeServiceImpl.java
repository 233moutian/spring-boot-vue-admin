package com.zoctan.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zoctan.api.core.memcache.MemcacheClient;
import com.zoctan.api.service.QrcodeService;
import com.zoctan.api.core.redis.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by zxw on 2018/8/6 0006.
 * 二维码业务实现类
 */
@Service
public class QrcodeServiceImpl implements QrcodeService {
    private static Logger logger = LoggerFactory.getLogger(QrcodeServiceImpl.class);

    @Autowired
    MemcacheClient memcacheClient;
    JedisUtil jedisUtil = JedisUtil.getInstance();


    /*
    * Double money, Date createTime, String orderId, String Qrcode
    * */
    @Transactional
    public void addQrcode(Map map){
        String methodName = "QrcodeController.getQrcode";


        String mapJson = JSONObject.toJSONString(map);
//        boolean isSession = memcacheClient.add(map.get("orderId").toString(), mapJson);
        String status = jedisUtil.STRINGS.setEx(map.get("orderId").toString(), 123 , mapJson);

        logger.info("methodName:{}|isSession:{}", methodName, status);
    }


}
