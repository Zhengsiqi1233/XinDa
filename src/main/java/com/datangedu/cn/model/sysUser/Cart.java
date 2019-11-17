package com.datangedu.cn.model.sysUser;

public class Cart {
    private String produtId;

    private Integer buyNum;

    private String produtName;

    private Integer price;

    private Integer sum;

    private String providerName;

    private String memberId;

    private String memberName;

    private String providerId;

    private byte[] produtImg;

    public String getProdutId() {
        return produtId;
    }

    public void setProdutId(String produtId) {
        this.produtId = produtId == null ? null : produtId.trim();
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName == null ? null : produtName.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public byte[] getProdutImg() {
        return produtImg;
    }

    public void setProdutImg(byte[] produtImg) {
        this.produtImg = produtImg;
    }
}