package com.datangedu.cn.controller.bussinessOrder;

import java.util.ArrayList;
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
import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.ProviderProdut;



		

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.service.BusinessOrderService;
import com.datangedu.cn.service.CartService;

@RestController
@RequestMapping("business")
public class BussinessOrderController {
	@Resource
	BusinessOrderService businessOrderService;
	@Resource
	CartService cartService;
	/*
	 * 根据服务商id获取订单列表
	 */
	@RequestMapping(value = "businessorderlistbyid", method = RequestMethod.GET)
	public Map<String,Object> businessOrderListById(HttpServletRequest request, String providerid){
		System.out.println("businessOrderList start");
		HttpSession session =  request.getSession();
		System.out.println("服务商id : " + providerid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<BusinessOrder> businessOrderList = businessOrderService.getBusinessOrderListById(providerid);
		System.out.println("列表大小： " + businessOrderList.size());
		map.put("businessOrderList", businessOrderList);
		
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
	/*
	 * 生成订单
	 */
	@ResponseBody
	@RequestMapping(value="/businesscart",method=RequestMethod.GET)	
	public Map<String,Object> bussinessInsert(HttpServletRequest request,String memberid,String memberName, String produtId, String num){
		System.out.println("bussinessInsert start");
		Map<String,Object> map=new HashMap<String,Object>();
		List<Cart>  cart= new ArrayList<>();
		System.out.println("produtId : " + produtId );
		
		List<BusinessOrder> businessOrder = businessOrderService.getBusinessOrderInsert(request, memberid, memberName);
		String[] arr=businessOrder.get(0).getOrderInfo().split(",");
	
		for(int i =0 ;i<arr.length;i++)
		{
		    String[] arr1 = arr[i].split("\\*");
		    for(int j =0 ; j < arr1.length; j ++){
		    	String temp1 = arr1[j];
		    	if(j % 2 == 0){
			    	//id
			    	System.out.println(temp1);
			    	List<Cart> cart1 = businessOrderService.getBusinessOrderName(temp1);
			    	System.out.println(cart1.size());
			    	String name = cart1.get(0).getProdutName();
			    	System.out.println(name);
			    	
			    	cart.add(cart1.get(0));
			    	System.out.println("cart.size:" + cart.size());
			    }
		    	if(j % 2 == 1){
		    	//数量
		    		System.out.println(temp1);
		    		List<Cart>  list = businessOrderService.getBusinessOrderName(temp1);
		   // 	int number = list.get(0).getBuyNum();
		    	//System.out.println(number);
		    	}
		    }    
		}
		List<BusinessOrder> list = businessOrderService.getBusinessOrderByMemberId(request, memberid);
		map.put("list", list);
		map.put("businessOrder", businessOrder);
		map.put("cart", cart);
		System.out.println(cart.size());
		return map;
	}
	
/*
 * 支付
 */
	@ResponseBody
	@RequestMapping(value="/businesspay",method=RequestMethod.GET)
	public Map<String, Object> businessPay(HttpServletRequest request, String businessNo, String val){
		System.out.println("businesspay start");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("支付方式：" + val);
		int list = businessOrderService.getBusinessPay(request, businessNo, val);
		return map;
		
	}

}
