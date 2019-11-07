package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.ProviderProdut;

public interface BussinessOrderService {

	/*
	 * List<ProviderProdut> getProviderProdutList();
	 * 
	 * int setPProviderProdutDelete(HttpServletRequest request);
	 * 
	 * List<ProviderProdut> getProviderProdutPage(HttpServletRequest request);
	 */
	List<BusinessOrder> getBussinessOrderList(HttpServletRequest request);

	List<BusinessOrder> getBussinessOrderPage(HttpServletRequest request);

	List<BusinessOrder> getBussinessOrderToday(HttpServletRequest request);

	List<BusinessOrder> getBussinessOrderWeek(HttpServletRequest request);

	List<BusinessOrder> getBussinessOrderMonth(HttpServletRequest request);

	int getBussinessOrderSum(HttpServletRequest request);

	int getBussinessOrderTodaySum(HttpServletRequest request);

	int getBussinessOrderWeekSum(HttpServletRequest request);

	int getBussinessOrderMonthSum(HttpServletRequest request);


}
