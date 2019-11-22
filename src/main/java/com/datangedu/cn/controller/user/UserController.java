package com.datangedu.cn.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.dao.mapper.UserMapper;
import com.datangedu.cn.model.sysUser.User;
import com.datangedu.cn.service.UserService;
@RestController
@RequestMapping("user")
public class UserController {
	@Resource
	UserMapper userMapper;
	@Resource
	UserService userService;
	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = userService.login(request);
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
			
			map.put("userid", list.get(0).getId());
			
			map.put("username", list.get(0).getUserName());
			System.out.println(list.get(0).getUserName());
			map.put("mem", "登陆成功");
		}
		
		return map;
	}
	/*
	 * 服务商找回密码
	 */
	@RequestMapping(value = "userfind", method = RequestMethod.POST)
	public Map<String, Object> findPassword(HttpServletRequest request){
		System.out.println("findpassword start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = userService.findPassword(request);
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
				User user=new User();
				user.setPassword(request.getParameter("password"));
				user.setCellphone(request.getParameter("cellphone"));
				userMapper.updateByExample1(user);
				map.put("mem", "修改密码成功");
				
			}		
		}
		return map;	
	}

}
