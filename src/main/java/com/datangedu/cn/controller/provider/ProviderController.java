package com.datangedu.cn.controller.provider;



	

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.ProviderService;

@RestController
@RequestMapping("provider")
public class ProviderController {
	@Resource
	ProviderService providerService;
	
	@Resource
	ProviderMapper providerMapper;
	/*
	 * 服务商登陆
	 */
	@RequestMapping(value = "providerlogin", method = RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Provider> list = providerService.login(request);
		if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "密码不能为空");
		}else if(list == null) {
			map.put("mem", "请输入正确的手机号或密码");
		}else if(request.getParameter("inputCode").length() == 0) {
			map.put("mem", "验证码不能为空");
		}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
			map.put("mem", "请输入正确的验证码 ");
		}else {	
			map.put("providerid", list.get(0).getId());
			map.put("provider", list.get(0));
			map.put("mem", "登陆成功");
		}
		
		return map;
	}
	/*
	 * 服务商找回密码
	 */
	@RequestMapping(value = "providerfind", method = RequestMethod.POST)
	public Map<String, Object> findPassword(HttpServletRequest request){
		System.out.println("findpassword start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Provider> list = providerService.findPassword(request);
		 if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("password").length() == 0) {
			map.put("mem", "密码不能为空");
		}else if(request.getParameter("inputCode").length() == 0) {
			map.put("mem", "验证码不能为空");
		}else if(request.getParameter("queren_password").length() == 0) {
			map.put("mem", "确认密码不能为空");
		}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
			map.put("mem", "请输入正确的验证码 ");
		}else {
			// 调用接口看用户是否存在，不存在直接提示， 存在重置密码
			if(list == null) {
				map.put("mem","请输入正确的手机号");
			}else {
				Provider provider = new Provider();
				provider.setPassword(request.getParameter("password"));
				provider.setCellphone(request.getParameter("cellphone"));
				providerMapper.updateByExample1(provider);
				map.put("mem", "修改密码成功");
				
			}		
		}
		return map;	
	}
	/*
	 * 服务商注册
	 */
	@RequestMapping(value = "providerregister", method = RequestMethod.POST)
	public Map<String,Object> userRegister(HttpServletRequest request){
		System.out.println("userRegion start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int providerList = providerService.providerRegion(request);
		if(request.getParameter("name").length() == 0) {
				map.put("mem", "姓名不能为空");
			}
		else if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("password").length() == 0) {
				map.put("mem", "密码不能为空");
			}else if(request.getParameter("inputCode").length() == 0) {
				map.put("mem", "验证码不能为空");
			}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
				map.put("mem", "请输入正确的验证码 ");
			}else if(request.getParameter("province").length() == 0) {
				map.put("mem", "省不能为空");
			}else if(request.getParameter("city").length() == 0) {
				map.put("mem", "城市不能为空");
			}else if(request.getParameter("area").length() == 0) {
				map.put("mem", "城市不能为空");
			}else {
				map.put("mem", "注册成功");
			}
		
		return map;
	}
	

	@RequestMapping(value="/providerlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerList=providerService.getProviderList(request);
		map.put("providerList", providerList);
		return map;
	}
	
	@RequestMapping(value="/providerpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerPage=providerService.getProviderPage(request);
		map.put("providerPage", providerPage);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping(value="/providerstop",method=RequestMethod.GET)	
	public Map<String,Object> ProviderStop(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerStop=providerService.getProviderStop(request);
		map.put("providerStop", providerStop);
		return map;
	}


}
