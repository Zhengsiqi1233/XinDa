  package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.BusinessOrderMapper;
import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import com.datangedu.cn.service.BussinessOrderService;
import com.datangedu.cn.service.ProviderProdutControllerService;

@Service("BussinessOrderService")
public class BussinessOrderServiceImpl implements BussinessOrderService {

	@Resource
	BusinessOrderMapper businessOrderMapper;

	@Override
	public List<BusinessOrder> getBussinessOrderList(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByExample(businessOrderExample);
	}

	@Override
	public List<BusinessOrder> getBussinessOrderPage(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		businessOrderExample.setLikeName(request.getParameter("business_no"));
		businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<BusinessOrder> bussinessOrderPage=businessOrderMapper.selectByLike(businessOrderExample);
			return bussinessOrderPage;
	}

	@Override
	public List<BusinessOrder> getBussinessOrderToday(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByToday(businessOrderExample);
	}

	@Override
	public List<BusinessOrder> getBussinessOrderWeek(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByWeek(businessOrderExample);
	}

	@Override
	public List<BusinessOrder> getBussinessOrderMonth(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByMonth(businessOrderExample);
	}

	@Override
	public int getBussinessOrderSum(HttpServletRequest request) {
		return businessOrderMapper.selectBySum();
	}

	@Override
	public int getBussinessOrderTodaySum(HttpServletRequest request) {
		return businessOrderMapper.selectByTodaySum();
	}

	@Override
	public int getBussinessOrderWeekSum(HttpServletRequest request) {
		return businessOrderMapper.selectByWeekSum();
	}

	@Override
	public int getBussinessOrderMonthSum(HttpServletRequest request) {
		return businessOrderMapper.selectByMonthSum();
	}

}
