package com.datangedu.cn.controller.providerProdut;

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

import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.service.ProviderProdutControllerService;

@Controller
@RequestMapping("/providerproductcontroller")
public class ProviderProdutController {
	@Resource
	ProviderProdutControllerService providerProdutControllerService;

	@ResponseBody
	@RequestMapping(value="/providerprodutlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderProdutList(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		List<ProviderProdut> providerProdutList=providerProdutControllerService.getProviderProdutList(request);
		map.put("providerProdutList", providerProdutList);
		return map; 
	}
	@ResponseBody
	@RequestMapping(value="/providerprodutdelete",method=RequestMethod.POST)	
	public Map<String, Object> userDelete(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		int providerProdutInfo=providerProdutControllerService.setPProviderProdutDelete(request);
		map.put("msg","恭喜删除成功");
		map.put("code", 1);
		return map;			
   }
	@ResponseBody
	@RequestMapping(value="/providerprodutpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderProdutPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<ProviderProdut> providerProdutPage=providerProdutControllerService.getProviderProdutPage(request);
		map.put("providerProdutPage", providerProdutPage);
		map.put("code", 1);
		return map;
	}
	

}
