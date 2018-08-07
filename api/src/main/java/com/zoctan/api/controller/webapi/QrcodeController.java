package com.zoctan.api.controller.webapi;

import com.zoctan.api.core.redis.JedisUtil;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.model.pay.QrcodeItem;
import com.zoctan.api.service.QrcodeService;
import com.zoctan.api.util.DateUtils;
import com.zoctan.api.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by zxw on 2018/8/6 0006.
 * 二维码处理控制器
 */
@RestController
@RequestMapping("api/qrcode")
public class QrcodeController {
    private static Logger logger = LoggerFactory.getLogger(QrcodeController.class);

    @Autowired
    private QrcodeService qrcodeService;

    /*
    * 接收二维码
    *
    * */
    @PostMapping("addQrcode")
    public Result addQrcode(@RequestParam String money,     // 付费金额,单位元
                            @RequestParam String createTime,// 创建时间2018-08-01 16:35:15
                            @RequestParam String orderId,   // 订单编号
                            @RequestParam String qrcode,    // 二维码
                            @RequestParam String sign,      // 签名参数
                            HttpServletRequest req) {
        QrcodeItem qrcodeItem = new QrcodeItem();
        qrcodeItem.setMoney(Long.valueOf(money));
        qrcodeItem.setOrderId(orderId);
        qrcodeItem.setQrcode(qrcode);
        qrcodeItem.setSign(sign);
        qrcodeItem.setCreateTime(DateUtils.getDateByStringWithDateFormatDefault(createTime));
        qrcodeItem.setExpireTime(JedisUtil.getInstance().EXPIRE_ONEDAY);    // 补参
        qrcodeItem.setStatus(1);                                        // 补参
        //  解签本来就有验参功能,如果少传了什么参数,那也肯定是他那边传过来的时候就已经有问题了.这里不做处理,接口的调用方去处理.
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
        String ip = WebUtils.getRemoteIp(req);
        String methodName = "QrcodeController.addQrcode";
        Result result = qrcodeService.addQrcode(qrcodeItem);
        logger.info("methodName:{}|sessionId:{}|requestIp:{}", methodName, sessionId, ip);
        return result;
    }

    /*
    * 提取二维码
    *
    * */
    @GetMapping("getQrcode")
    public Result getQrcode(@RequestParam String money,     // 付费金额
                            @RequestParam String sign,      // 签名参数
                            HttpServletRequest req) {
        //  解签本来就有验参功能,如果少传了什么参数,那也肯定是他那边传过来的时候就已经有问题了.这里不做处理,接口的调用方去处理.
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
        String ip = WebUtils.getRemoteIp(req);
        String methodName = "QrcodeController.getQrcode";

        Result result = qrcodeService.getQrcode(money, sign);

        logger.info("methodName:{}|sessionId:{}|requestIp:{}", methodName, sessionId, ip);
        return result;
    }

}
