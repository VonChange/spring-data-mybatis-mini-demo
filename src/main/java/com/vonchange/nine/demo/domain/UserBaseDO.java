package com.vonchange.nine.demo.domain;

import com.vonchange.mybatis.tpl.annotation.InsertIfNull;
import com.vonchange.mybatis.tpl.annotation.UpdateDuplicateKeyIgnore;
import com.vonchange.mybatis.tpl.annotation.UpdateIfNull;
import com.vonchange.mybatis.tpl.annotation.UpdateNotNull;

import javax.persistence.Id;
import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "user_base")
public class UserBaseDO {
    @Id
    private Long id;
    private String userName;
    private String  mobilePhone;
    //@InsertIfNull("0")
    @UpdateNotNull
    private Integer isDelete;
    @InsertIfNull(function = "now()")
    @UpdateNotNull
    private Date createTime;
    @UpdateDuplicateKeyIgnore
    @InsertIfNull(function = "now()")
    @UpdateIfNull(function = "now()")
    private Date updateTime;
    public UserBaseDO(){

    }
    public UserBaseDO(Long id,String userName,String mobilePhone,Integer isDelete,Date createTime,Date updateTime){
        this.id=id;
        this.userName=userName;
        this.mobilePhone=mobilePhone;
        this.isDelete=isDelete;
        this.createTime=createTime;
        this.updateTime=updateTime;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        return "UserBaseDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
