package com.datangedu.cn.model.sysUser;

import java.util.Date;

public class ProviderProdut {
    private String id;

    private String providerId;

    private String serviceName;

    private String serviceInfo;

    private String serviceImg;

    private String serviceContent;

    private Integer price;

    private Integer salesNum;

    private String region;

    private Date createTime;

    private Integer recommend;

    private Integer necessary;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }

    public String getServiceImg() {
        return serviceImg;
    }

    public void setServiceImg(String serviceImg) {
        this.serviceImg = serviceImg == null ? null : serviceImg.trim();
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getNecessary() {
        return necessary;
    }

    public void setNecessary(Integer necessary) {
        this.necessary = necessary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}