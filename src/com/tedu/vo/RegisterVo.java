package com.tedu.vo;

public class RegisterVo {
    private String uname;
    private String upwd;
    private String upwdconfirm;
    private String email;
    private String phone;

    public RegisterVo(String uname, String upwd, String upwdconfirm, String email, String phone) {
        this.uname = uname;
        this.upwd = upwd;
        this.upwdconfirm = upwdconfirm;
        this.email = email;
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUpwdconfirm() {
        return upwdconfirm;
    }

    public void setUpwdconfirm(String upwdconfirm) {
        this.upwdconfirm = upwdconfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
