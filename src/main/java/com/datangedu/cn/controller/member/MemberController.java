package com.datangedu.cn.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.RegionService;

@RestController
@RequestMapping("member")

public class MemberController {
	
	@Resource
	MemberService memberService;
	@Resource
	MemberMapper memberMapper;
	/*
	 * 会员登陆
	 */
	@RequestMapping(value = "memberlogin", method = RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> list = memberService.login(request);
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
			
			map.put("mem", "登陆成功");
		}
		
		return map;
	}
	/*
	 * 会员找回密码
	 */
	@RequestMapping(value = "memberfind", method = RequestMethod.POST)
	public Map<String, Object> findPassword(HttpServletRequest request){
		System.out.println("findpassword start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> list = memberService.findPassword(request);
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
				Member member = new Member();
				member.setPassword(request.getParameter("password"));
				member.setCellphone(request.getParameter("cellphone"));
				System.out.println("else"+member.getCellphone()+member.getPassword());
				memberMapper.updateByExample1(member);
				map.put("mem","修改密码成功");
				System.out.println("else");
			}		
		}
		return map;	
	}
	/*
	 * 会员注册
	 */
	@RequestMapping(value = "memberregister", method = RequestMethod.POST)
	public Map<String,Object> userRegister(HttpServletRequest request){
		System.out.println("userRegion start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int memberList = memberService.userRegion(request);
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
}
