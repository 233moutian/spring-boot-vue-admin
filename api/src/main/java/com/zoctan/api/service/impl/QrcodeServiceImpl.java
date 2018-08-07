package com.zoctan.api.service.impl;

import com.zoctan.api.api.RemitApi;
import com.zoctan.api.core.container.SystemEnums;
import com.zoctan.api.core.jwt.JWTSetting;
import com.zoctan.api.core.memcache.MemcacheClient;
import com.zoctan.api.core.redis.JedisUtil;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.service.AbstractService;
import com.zoctan.api.mapper.QrcodeMapper;
import com.zoctan.api.model.pay.QrcodeItem;
import com.zoctan.api.service.QrcodeService;
import com.zoctan.api.util.DateUtils;
import com.zoctan.api.util.DateUtilsZXW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zxw on 2018/8/6 0006.
 * 二维码业务实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QrcodeServiceImpl extends AbstractService<QrcodeItem> implements QrcodeService {
    private static Logger logger = LoggerFactory.getLogger(QrcodeServiceImpl.class);

    @Autowired
    private QrcodeMapper qrcodeMapper;
    /*@Autowired
    private MemcacheClient memcacheClient;*/
    @Resource
    private JWTSetting jwtSetting;


    /*
    * 存入二维码及其其他信息
    * */
    @Transactional
    public Result addQrcode(QrcodeItem qrcodeItem) {
        String methodName = "QrcodeController.getQrcode";
        // 参数设置
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("money", qrcodeItem.getMoney().toString());
        paramMap.put("createTime", DateUtils.getDateString(qrcodeItem.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        paramMap.put("orderId", qrcodeItem.getOrderId());
        paramMap.put("qrcode", qrcodeItem.getQrcode());
        paramMap.put("sign", qrcodeItem.getSign());
        System.out.println(paramMap);
        Boolean isOK = RemitApi.checkParams(paramMap, jwtSetting.getPublicKey());
        if (!isOK) {         // 如果签名验证不通过
            return new Result
                    .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_801001.getCode()))
                    .msg(SystemEnums.RESPONSE_Code_801001.getName())
                    .build();
        }
        // 一个二维码只能存一次, 去数据库检索一下
        if (qrcodeMapper.selectCount(new QrcodeItem(paramMap.get("qrcode"))) > 0) {
            return new Result
                    .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_801005.getCode()))
                    .msg(SystemEnums.RESPONSE_Code_801005.getName())
                    .build();
        }
        //boolean isSession = memcacheClient.add(map.get("orderId").toString(), mapJson);   改用redis,弃用memcached
        // 新增hash数据, 将此map存进redis, util中没有提供设置过期时间的方法,只能另外设置
        String status = JedisUtil.getInstance().HASH.hmset(paramMap.get("money") + "|" + paramMap.get("orderId"), paramMap);
        // 设置过期时间, 因为util里面没有提供add hash并且设置过期时间的方法,只能先新增数据再设置过期时间
        Long redisRow = JedisUtil.getInstance().KEYS.expire(paramMap.get("money") + "|" + paramMap.get("orderId"), JedisUtil.getInstance().EXPIRE_ONEDAY);
        if (!"OK".equals(status) && redisRow > 0) {     // 如果redis插入失败
            return new Result
                    .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_801002.getCode()))
                    .msg(SystemEnums.RESPONSE_Code_801002.getName())
                    .build();
        }

        qrcodeMapper.insertSelective(qrcodeItem);
        logger.info("methodName:{}|status:{}", methodName, status);
        return new Result
                .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_0.getCode()))
                .msg(SystemEnums.RESPONSE_Code_0.getName())
                .build();
    }

    @Override
    public Result getQrcode(String money, String sign) {
        String methodName = "QrcodeController.getQrcode";
        // 参数设置
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("money", money);
        paramMap.put("sign", sign);
        Boolean isOK = RemitApi.checkParams(paramMap, jwtSetting.getPublicKey());
        if (!isOK) {     // 如果签名验证不通过
            return new Result
                    .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_801001.getCode()))
                    .msg(SystemEnums.RESPONSE_Code_801001.getName())
                    .build();
        }
        Set<String> keySets = JedisUtil.getInstance().KEYS.keys(money + "|*");
        if (keySets == null || keySets.isEmpty()) {
            return new Result
                    .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_801004.getCode()))
                    .msg(SystemEnums.RESPONSE_Code_801004.getName())
                    .build();
        }
        String[] keys = keySets.toArray(new String[keySets.size()]);
        Map<String, String> resultMap = JedisUtil.getInstance().HASH.hgetAll(keys[0]);
        JedisUtil.getInstance().KEYS.del(keys[0]);    // 拿到手就踢掉这条数据
        Example example = new Example(QrcodeItem.class);
        example.createCriteria().andEqualTo("orderId", resultMap.get("orderId"));
        QrcodeItem qrcodeItem = new QrcodeItem();
        qrcodeItem.setStatus(2);    // 2.客户端已获取
        qrcodeItem.setUpdateTime(new Date());
        qrcodeMapper.updateByConditionSelective(qrcodeItem, example);
        return new Result
                .Builder(Integer.parseInt(SystemEnums.RESPONSE_Code_0.getCode()))
                .msg(SystemEnums.RESPONSE_Code_0.getName())
                .data(resultMap)
                .build();
    }

}
