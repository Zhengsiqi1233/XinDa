package com.datangedu.cn.model.sysUser;

import java.util.Date;

public class Provider {
    private String id;

    private String name;

    private String providerInfoUser;

    private String providerInfoMember;

    private String cellphone;

    private String password;

    private String providerImg;

    private String region;

    private String wechat;

    private String qq;

    private String email;

    private String authFile;

    private String workTime;

    private Date createTime;

    private String tel;

    private Integer recommend;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProviderInfoUser() {
        return providerInfoUser;
    }

    public void setProviderInfoUser(String providerInfoUser) {
        this.providerInfoUser = providerInfoUser == null ? null : providerInfoUser.trim();
    }

    public String getProviderInfoMember() {
        return providerInfoMember;
    }

    public void setProviderInfoMember(String providerInfoMember) {
        this.providerInfoMember = providerInfoMember == null ? null : providerInfoMember.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getProviderImg() {
        return providerImg;
    }

    public void setProviderImg(String providerImg) {
        this.providerImg = providerImg == null ? null : providerImg.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAuthFile() {
        return authFile;
    }

    public void setAuthFile(String authFile) {
        this.authFile = authFile == null ? null : authFile.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}