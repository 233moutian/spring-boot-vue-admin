package com.zoctan.api.model.pay;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by zxw on 2018/8/7 0007.
 * 二维码相关信息实体类
 *
 */
@Table(name = "qrcode_tiem")
public class QrcodeItem {
    /**
     * 二维码表Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单金额,单位为分,显示的时候除以100即可
     */
    @NotEmpty(message = "订单金额不能为空")
    private Long money;

    /**
     * 订单id
     */
    @NotEmpty(message = "订单id不能为空")
    @Size(min = 6, message = "订单id长度不能小于6")
    private String orderId;

    /**
     * 二维码
     */
    @NotEmpty(message = "二维码不能为空")
    @Size(min = 6, message = "二维码长度不能小于6")
    private String qrcode;

    /**
     * 签名
     */
    @NotEmpty(message = "签名不能为空")
    @Size(min = 6, message = "签名长度不能小于6")
    private String sign;

    /**
     * 状态: 1.未使用、2.客户端已获取、3.扣费成功、4.已失效
     */
    private Integer status;

    /**
     * 失效时间,单位秒
     */
    private Integer expireTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;


    public QrcodeItem() {
    }

    public QrcodeItem(@NotEmpty(message = "二维码不能为空") @Size(min = 6, message = "二维码长度不能小于6") String qrcode) {
        this.qrcode = qrcode;
    }

    @Override
    public String toString() {
        return "QrcodeItem{" +
                "id=" + id +
                ", money=" + money +
                ", orderId='" + orderId + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", expireTime=" + expireTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
