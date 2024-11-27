package com.parking.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 会员信息
 * @author zhengkai.blog.csdn.net
 * @date 2024-11-26
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 生日
    */
    private String birth;

    /**
    * 姓名
    */
    private String fullName;

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


    public Member() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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