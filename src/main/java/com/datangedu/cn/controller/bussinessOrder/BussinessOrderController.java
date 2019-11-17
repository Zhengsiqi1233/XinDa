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
import com.datangedu.cn.model.sysUser.Provider;
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
	 * 根据服务商id获取服务中的订单列表
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
	/*
	 * 获取已停用的订单列表
	 */
	@RequestMapping(value = "businessorderlistbyidstop", method = RequestMethod.GET)
	public Map<String,Object> businessOrderListStop(HttpServletRequest request, String providerid){
		System.out.println("businessOrderListStop start");
		HttpSession session =  request.getSession();
		System.out.println(providerid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<BusinessOrder> businessOrderListStop = businessOrderService.getBusinessOrderListByIdStop(providerid);
		map.put("businessOrderListStop", businessOrderListStop);
		System.out.println("cellphone : " + businessOrderListStop.get(0).getMemberCellphone());
		return map;
	}
	/*
	 * 根据服务名称查询订单
	 */
	@ResponseBody
	@RequestMapping(value="/bussinessorderlike",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderLike(HttpServletRequest request,String providerid){
		HttpSession session =  request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderLike=businessOrderService.getBussinessOrderLike(request,providerid);
		map.put("bussinessOrderLike", bussinessOrderLike);
		map.put("code", 1);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/bussinessorderlikestop",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderLikeStop(HttpServletRequest request,String providerid){
		HttpSession session =  request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderLikeStop=businessOrderService.getBussinessOrderLikeStop(request,providerid);
		map.put("bussinessOrderLikeStop", bussinessOrderLikeStop);
		map.put("code", 1);
		return map;
	}
	/*
	 * 查询用户端的所有订单
	 */
	@ResponseBody
	@RequestMapping(value="/bussinessorderlist",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		//session.setAttribute("memberid", memberid);
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderList=businessOrderService.getBussinessOrderList(request);
		map.put("bussinessOrderList", bussinessOrderList);
		return map; 
	}
	/*
	 * 根据订单号删除未完成的订单
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteorder",method =RequestMethod.POST)
		public Map<String, Object> orderDelete(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		int order=businessOrderService.setOrderDelete(request);
		map.put("msg","恭喜删除成功");
		map.put("code", 1);
		return map;			
   }
	/*
	 * 根据未完成的订单进行付款
	 */
	@ResponseBody
	@RequestMapping(value="/bussinessorderpay",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderPay(HttpServletRequest request,String business_no){
		HttpSession session = request.getSession();
		session.setAttribute("business_no", business_no);
		System.out.println(business_no);
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessOrderPay=businessOrderService.getBussinessOrderPay(business_no);
		map.put("bussinessOrderPay", bussinessOrderPay);
		return map; 
	}
	
	/*
	 * 根据输入的订单号查询订单(用户的)
	 */
	@ResponseBody
	@RequestMapping(value="/bussinessnolike",method=RequestMethod.GET)	
	public Map<String,Object> bussinessNoLike(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<BusinessOrder> bussinessNoLike=businessOrderService.getBussinessNoLike(request);
		map.put("bussinessNoLike", bussinessNoLike);
		map.put("code", 1);
		return map;
	}
	
	/*
	 * 评价已完成的订单
	 */
	
	@ResponseBody
	@RequestMapping(value = "/evaluateInsert",method =RequestMethod.POST)
		public Map<String, Object> evaluateInsert(HttpServletRequest request){
		HttpSession session =  request.getSession();
		//session.setAttribute("business_no", business_no);
		//System.out.println(business_no);
		Map<String, Object> map=new HashMap<String, Object>();
		businessOrderService.evaluateInsert(request);
		//BusinessOrder businessOrder = new BusinessOrder();
		//businessOrder.setEvaluate(request.getParameter("evaluate"));
		map.put("code",1);
		return map;	
	}
		
	@ResponseBody
	@RequestMapping(value="/bussinessorderpage",method=RequestMethod.GET)	
	public Map<String,Object> bussinessOrderPage(HttpServletRequest request){
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
