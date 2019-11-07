package com.datangedu.cn.controller.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.service.ProviderControllerService;

@Controller
@RequestMapping("/membercontroller")
public class MemberComtroller {
	@Resource
	ProviderControllerService providerControllerService;

	@ResponseBody
	@RequestMapping(value="/providerlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerList=providerControllerService.getProviderList(request);
		map.put("providerList", providerList);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/providerpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerPage=providerControllerService.getProviderPage(request);
		map.put("providerPage", providerPage);
		map.put("code", 1);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/providerstop",method=RequestMethod.GET)	
	public Map<String,Object> ProviderStop(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerStop=providerControllerService.getProviderStop(request);
		map.put("providerStop", providerStop);
		return map;
	}

}
