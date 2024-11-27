package com.parking.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 会员积分
 * @author zhengkai.blog.csdn.net
 * @date 2024-11-26
 */
public class MemberCard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;

    /**
    * 会员编号
    */
    private String memberId;

    /**
    * 当前可用积分
    */
    private String curQty;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建日期
    */
    private Date createDate;

    /**
    * 更新人
    */
    private String updateBy;

    /**
    * 更新日期
    */
    private Date updateDate;

    /**
    * 备注
    */
    private String remark;

    /**
    * 版本
    */
    private Integer version;

    /**
    * 状态
    */
    private Integer state;


    public MemberCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCurQty() {
        return curQty;
    }

    public void setCurQty(String curQty) {
        this.curQty = curQty;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}