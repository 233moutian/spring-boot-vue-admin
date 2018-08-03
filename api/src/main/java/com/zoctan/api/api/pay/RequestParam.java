package com.zoctan.api.api.pay;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jacky on 16/9/8.
 * 请求支付参数类
 */
public class RequestParam {

    private String version="1.1";  //必须
    private String merchantId="100001";  //必须
    private String merchantTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //必须
    private String traceNO=String.valueOf(System.currentTimeMillis()); //必须
    private String requestAmount="0.01"; //必须
    private String paymentCount="1";
    private String payment_1;     //必须
    private String payment_2;
    private String returnUrl="www.baidu.com";  //必须
    private String notifyUrl="www.baidu.com";  //必须
    private String goodsName="哇哈哈";  //必须
    private String goodsCount="1";  //必须
    private String ip="192.168.0.1";      //必须
    private String sign;  //必须
    private String extend="app_name=极品影院extreme&package_name=com.media.extreme&周年纪念版";

    public RequestParam() {
    }

    public static RequestParam createAPPDefault(){
       RequestParam param=new RequestParam();
        StringBuffer sb=new StringBuffer();
        sb.append("4_").append(param.getRequestAmount());
        param.setPayment_1(sb.toString());
        return param;
    }

    public static RequestParam createH5Default(){
        RequestParam param=new RequestParam();
        StringBuffer sb=new StringBuffer();
        sb.append("5_").append(param.getRequestAmount());
        param.setPayment_1(sb.toString());
        return param;
    }

    public static RequestParam createScanDefault(){
        RequestParam param=new RequestParam();
        StringBuffer sb=new StringBuffer();
        sb.append("3_").append(param.getRequestAmount());
        param.setPayment_1(sb.toString());
        return param;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTime() {
        return merchantTime;
    }

    public void setMerchantTime(String merchantTime) {
        this.merchantTime = merchantTime;
    }

    public String getTraceNO() {
        return traceNO;
    }

    public void setTraceNO(String traceNO) {
        this.traceNO = traceNO;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(String paymentCount) {
        this.paymentCount = paymentCount;
    }

    public String getPayment_1() {
        return payment_1;
    }

    public void setPayment_1(String payment_1) {
        this.payment_1 = payment_1;
    }

    public String getPayment_2() {
        return payment_2;
    }

    public void setPayment_2(String payment_2) {
        this.payment_2 = payment_2;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
