package com.datangedu.cn.controller.bussinessOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.ProviderProdut;



		

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.service.BusinessOrderService;

@RestController
@RequestMapping("business")
public class BussinessOrderController {
	@Resource
	BusinessOrderService businessOrderService;
	/*
	 * 根据服务商id获取订单列表
	 */
	@RequestMapping(value = "businessorderlistbyid", method = RequestMethod.GET)
	public Map<String,Object> businessOrderList(HttpServletRequest request, String providerid){
		System.out.println("businessOrderList start");
		HttpSession session =  request.getSession();
		System.out.println(providerid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<BusinessOrder> businessOrderList = businessOrderService.getBusinessOrderListById(providerid);
		map.put("businessOrderList", businessOrderList);
		System.out.println("cellphone : " + businessOrderList.get(0).getMemberCellphone());
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/bussinessorderlist",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderList=businessOrderService.getBussinessOrderList(request);
		map.put("bussinessOrderList", bussinessOrderList);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessorderpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderProdutPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderPage=businessOrderService.getBussinessOrderPage(request);
		map.put("bussinessOrderPage", bussinessOrderPage);
		map.put("code", 1);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessordertoday",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderToday(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderToday=businessOrderService.getBussinessOrderToday(request);
		map.put("bussinessOrderToday", bussinessOrderToday);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessorderweek",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderWeek(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderWeek=businessOrderService.getBussinessOrderWeek(request);
		map.put("bussinessOrderWeek", bussinessOrderWeek);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessordermonth",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderMonth(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderMonth=businessOrderService.getBussinessOrderMonth(request);
		map.put("bussinessOrderMonth", bussinessOrderMonth);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessordersum",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderSum(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		int bussinessOrderSum=businessOrderService.getBussinessOrderSum(request);
		map.put("bussinessOrderSum", bussinessOrderSum);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessordertodaysum",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderTodaySum(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		int bussinessOrderTodaySum=businessOrderService.getBussinessOrderTodaySum(request);
		map.put("bussinessOrderTodaySum", bussinessOrderTodaySum);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessorderweeksum",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderWeekSum(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		int bussinessOrderWeekSum=businessOrderService.getBussinessOrderWeekSum(request);
		map.put("bussinessOrderWeekSum", bussinessOrderWeekSum);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessordermonthsum",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderMonthSum(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		int bussinessOrderMonthSum=businessOrderService.getBussinessOrderMonthSum(request);
		map.put("bussinessOrderMonthSum", bussinessOrderMonthSum);
		return map; 
	}
	



}
