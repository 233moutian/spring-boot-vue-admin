package com.zoctan.api.controller.webapi;

import com.zoctan.api.api.RemitApi;
import com.zoctan.api.core.jwt.JWTSetting;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.service.QrcodeService;
import com.zoctan.api.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    @Resource
    private JWTSetting jwtSetting;

    /*
    * 接收二维码
    *
    * */
    @PostMapping("getQrcode")
    public Result getQrcode(@RequestParam String money,
                            @RequestParam String createTime,
                            @RequestParam String orderId,
                            @RequestParam String Qrcode,
                            @RequestParam String sign,
                                 HttpServletRequest req) {
    //  解签本来就有验参功能,如果少传了什么参数,那也肯定是他那边传过来的时候就已经有问题了.这里不做处理,接口的调用方去处理.
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
        String ip = WebUtils.getRemoteIp(req);
        String methodName = "QrcodeController.getQrcode";
        // 参数设置
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("money", money);
        paramMap.put("createTime", createTime);
        paramMap.put("orderId", orderId);
        paramMap.put("Qrcode", Qrcode);
        paramMap.put("sign", sign);
//        paramMap.put("ip", ip);
        RemitApi.checkParams(paramMap, jwtSetting.getPublicKey());
        qrcodeService.addQrcode(paramMap);
        logger.info("methodName:{}|sessionId:{}|requestIp:{}", methodName, sessionId, ip);
        return ResultGenerator.genOkResult();
    }

}
