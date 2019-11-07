package com.datangedu.cn.controller.bussinessOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping(value = "businessorderlist", method = RequestMethod.GET)
	public Map<String,Object> businessOrderList(HttpServletRequest request, String providerid){
		System.out.println("businessOrderList start");
		HttpSession session =  request.getSession();
		System.out.println(providerid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<BusinessOrder> businessOrderList = businessOrderService.getBusinessOrderList(providerid);
		map.put("businessOrderList", businessOrderList);
		System.out.println("cellphone : " + businessOrderList.get(0).getMemberCellphone());
		return map;
	}


}
