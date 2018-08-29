package com.zoctan.api.model;

import java.util.Date;
import javax.persistence.*;

public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 解锁码
     */
    @Column(name = "key_code")
    private String keyCode;

    /**
     * 开锁地点
     */
    private String local;

    /**
     * 还车地点
     */
    private String close;

    /**
     * 状态，0.没有被使用，1.正在使用
     */
    private Byte status;

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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取解锁码
     *
     * @return key_code - 解锁码
     */
    public String getKeyCode() {
        return keyCode;
    }

    /**
     * 设置解锁码
     *
     * @param keyCode 解锁码
     */
    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * 获取开锁地点
     *
     * @return local - 开锁地点
     */
    public String getLocal() {
        return local;
    }

    /**
     * 设置开锁地点
     *
     * @param local 开锁地点
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * 获取还车地点
     *
     * @return close - 还车地点
     */
    public String getClose() {
        return close;
    }

    /**
     * 设置还车地点
     *
     * @param close 还车地点
     */
    public void setClose(String close) {
        this.close = close;
    }

    /**
     * 获取状态，0.没有被使用，1.正在使用
     *
     * @return status - 状态，0.没有被使用，1.正在使用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态，0.没有被使用，1.正在使用
     *
     * @param status 状态，0.没有被使用，1.正在使用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}