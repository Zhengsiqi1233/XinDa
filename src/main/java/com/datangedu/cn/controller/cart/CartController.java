package com.datangedu.cn.controller.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.dao.mapper.CartMapper;
import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
	@Resource 
	CartService cartService;
	@Resource
	CartMapper cartMapper;
	/*
	 * 购物车列表
	 */
	@ResponseBody
	@RequestMapping(value="/membercart",method=RequestMethod.GET)	
	public  Map<String, Object> providerCart(HttpServletRequest request, String memberid,String providerId, String num){
		System.out.println("providerCart start");
		System.out.println("num" + num);
		System.out.println("providerId : " +providerId);
		Map<String,Object> map=new HashMap<String,Object>();
	    //map.put("memberCart", list);
	    // list = [{name: "啊啊啊", productlist:[{1,2,3}]},{name: "啊啊啊a", productlist:[{1,2,3}]}]
	    List<Map<String, Object>>  car =  new ArrayList<Map<String,Object>>();

	    List<Cart> list = cartService.getMemberCart(memberid);
	    List<Cart> list1 = null;
	    for(int i = 0 ; i < list.size(); i++) {
	    	String providerName = list.get(i).getProviderName();
	    	String providerId1 = list.get(i).getProviderId();
	    	Map<String, Object> map1 =new  HashMap<String,Object>();
	    	int num1 = 0;
	    	for (Map<String, Object> name : car) {

				if (name.get("name").equals(providerName)) {
					num1 = 1;
					break;
				}
			}
	    	if(num1 == 1) {
	    		continue;
	    	}else {  	
	    	 list1 = cartService.getMemberCartByName(providerName, memberid);
	    	map1.put("name", providerName);
	    	map1.put("productlist", list1);
	    	car.add(map1);
	    	}	
	  	}
		map.put("productlist", list1);
	    map.put("car", car);
	    return map;
	}
	    	
	    	//【1.2.3.4.5】
	    	/*if(car == null) {
	    		list.add((Cart)list1);
	    	}else {
	    		for(int j = 0 ; j< list1.size(); j++) {
	    			if(list1.get(j).getProviderName() == list.get(i).getProviderName()) {
	    				j = 1;
	    				break;
	    			}
	    			if(providerName == list1.get(j).getProviderName()) {
		    			list1.add((Cart)list1);
		    		}
	    			if(j == 1) {
	    				continue;
	    			}
	    			else {
	    				list.add((Cart)list1);
	    			}
	    		}		
	    	}
	    }
	    //for 循环 list
*/	    // 对比name
	    // 1 car 为空  直接差入  list.add
	    
	    // 定义一个变量int 用来处理当前店铺名字是否存在 初值为0，
	    // for  循环list 直接对比名字，如果名字相同 int 赋值为1 return;break;continue;
	    
	    // 2 car  不为空  对比name
	    // 				 		名字相同   productlist.add
	    //							判断int是否为1 是continue；
	    //							名字不同  list.add

	/*
	 * 购物车添加商品
	 */
	@ResponseBody
	@RequestMapping(value="/cartadd",method=RequestMethod.GET)	
	public Map<String, Object> cartAdd(HttpServletRequest request, String id, String memberid){
		System.out.println("cartAdd start");
		System.out.println("商品id：" + id);
		System.out.println("会员id ：  " + memberid);
		Map<String, Object> map = new HashMap<String,Object>();
		cartService.getCartAdd(id,memberid);
		return map;
	}
	
	/*
	 *产品数量改变
	 */
	@ResponseBody
	@RequestMapping(value="/reducenum",method=RequestMethod.GET)	
	public Map<String, Object> reduceNum(HttpServletRequest request,String produtId){
		System.out.println("reduceNum start");
		System.out.println("produtId : " + produtId);
		Map<String, Object> map = new HashMap<String,Object>();
		List<Cart> list = cartService.getReduceNum(request,produtId);
		Cart cart = new Cart();
		System.out.println("数量1： " +request.getParameter("orderNum"));
	    int num = Integer.parseInt(request.getParameter("orderNum"));
		cart.setBuyNum(num); 
		cart.setProdutId(produtId);
		int a = cartMapper.updateByNum(cart);
		System.out.println("影响行数：" + a);
		System.out.println("数量2： " + cart.getBuyNum());
		return map;
	}
	/*
	 * 删除购物车产品
	 */
	@ResponseBody
	@RequestMapping(value="/delcart",method=RequestMethod.GET)	
	public Map<String, Object> delCart(HttpServletRequest request,String produtId){
		System.out.println("delCart start");
		Map<String, Object> map = new HashMap<String,Object>();
		int a = cartService.getDelCart(request, produtId);
		map.put("code", 1);
		return map;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
