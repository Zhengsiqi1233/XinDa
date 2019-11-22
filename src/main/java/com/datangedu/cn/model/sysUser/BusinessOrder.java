package com.datangedu.cn.model.sysUser;

import java.util.Date;

public class BusinessOrder {
    private String businessNo;

    private String orderInfo;

    private String memberId;

    private String memberName;

    private String memberCellphone;

    private Integer orderSum;

    private Date createTime;

    private String evaluate;

    private Integer payType;

    private Integer status;

    private String providerId;

    private String providerName;

    private Integer orderNum;
<<<<<<< HEAD

=======
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
        
    private String produtId;
    
    private ProviderProdut produt;
    
    private Member member;
    
    

    public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ProviderProdut getProdut() {
		return produt;
	}

	public void setProdut(ProviderProdut produt) {
		this.produt = produt;
	}

<<<<<<< HEAD



    public String getBusinessNo() {

=======
	/*
	 * public String getProdutId() { return produtId; }
	 * 
	 * public void setProdutId(String produtId) { this.produtId = produtId; }
	 */

    public String getBusinessNo() {
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo == null ? null : orderInfo.trim();
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

    public String getMemberCellphone() {
        return memberCellphone;
    }

    public void setMemberCellphone(String memberCellphone) {
        this.memberCellphone = memberCellphone == null ? null : memberCellphone.trim();
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getProdutId() {
        return produtId;
    }

    public void setProdutId(String produtId) {
        this.produtId = produtId == null ? null : produtId.trim();
    }
}