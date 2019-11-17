package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.BusinessOrder;

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


}
