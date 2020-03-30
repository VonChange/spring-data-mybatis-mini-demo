package com.vonchange.nine.demo.domain;

//@Data
public class UserBaseVo {
    //private Long id;
    private String userName;
    private String  firstPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstPhone() {
        return firstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }
}
