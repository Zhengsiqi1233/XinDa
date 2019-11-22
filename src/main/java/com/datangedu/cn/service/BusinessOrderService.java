package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.ProviderProdut;

public interface BusinessOrderService {

	public List<BusinessOrder> getBusinessOrderListById(String providerid);
	
	public List<BusinessOrder> getBussinessOrderList(HttpServletRequest request);

	public List<BusinessOrder> getBussinessOrderPage(HttpServletRequest request);

	public List<BusinessOrder> getBussinessOrderToday(HttpServletRequest request);

	public List<BusinessOrder> getBussinessOrderWeek(HttpServletRequest request);

	public List<BusinessOrder> getBussinessOrderMonth(HttpServletRequest request);

	public int getBussinessOrderSum(HttpServletRequest request);

	public int getBussinessOrderTodaySum(HttpServletRequest request);

	public int getBussinessOrderWeekSum(HttpServletRequest request);

	public int getBussinessOrderMonthSum(HttpServletRequest request);


	public List<BusinessOrder> getBusinessOrderListByIdStop(String providerid);

	public List<BusinessOrder> getBussinessOrderLike(HttpServletRequest request,String providerid);

	public List<BusinessOrder> getBussinessOrderLikeStop(HttpServletRequest request, String providerid);

	public int setOrderDelete(HttpServletRequest request);

	public List<BusinessOrder> getBussinessOrderPay(String business_no);

	public List<BusinessOrder> getBussinessNoLike(HttpServletRequest request);

	public int evaluateInsert(HttpServletRequest request);
	

	public List<BusinessOrder> getBusinessOrderInsert(HttpServletRequest request, String memberid, String memberName, String sum);

	public List<BusinessOrder> getBusinessOrderByMemberId(HttpServletRequest request, String memberid);

	public int getBusinessPay(HttpServletRequest request, String businessNo,String val);

	public List<Cart> getBusinessOrderName(String temp1);

	public List<BusinessOrder> getBusinessOrderBuyNow(HttpServletRequest request, String produtid, String memberid,
			String membername);

	public List<ProviderProdut> getBusinessOrderNameBuyNow(String string);



}
