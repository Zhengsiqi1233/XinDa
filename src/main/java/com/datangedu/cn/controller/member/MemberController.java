package com.datangedu.cn.controller.member;

<<<<<<< HEAD
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.service.MemberControllerService;
import com.datangedu.cn.service.MemberService;


	
	


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
=======

>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.RegionService;
import com.datangedu.cn.util.MD5Util;

@RestController
@RequestMapping("member")

public class MemberController {
	
	@Resource
	MemberService memberService;
	@Resource
	MemberMapper memberMapper;
<<<<<<< HEAD

	

	/*
	 * 会员登陆
	 */

=======
	
	/*
	 * 会员登陆
	 */
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
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
<<<<<<< HEAD

			System.out.println("list.size" + list.size());
			//map.put("memberid",list.get(0).getId());
			//map.put("member", list.get(0));
			 

=======
			System.out.println("list.size" + list.size());
			//map.put("memberid",list.get(0).getId());
			//map.put("member", list.get(0));
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
			System.out.println(list.size());
			map.put("memberid", list.get(0).getId());
			map.put("membername", list.get(0).getName());

			map.put("mem", "登陆成功");
		}
		
		return map;
	}

	/*
	 * 会员找回密码
	 */
<<<<<<< HEAD

=======
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
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
<<<<<<< HEAD

		System.out.println("else");

=======
		System.out.println("else");
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
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
<<<<<<< HEAD

	/*
	 * 会员注册
	 */

=======
	/*
	 * 会员注册
	 */
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
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
<<<<<<< HEAD

=======
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	@ResponseBody
	@RequestMapping(value="/memberpage",method=RequestMethod.GET)	
	public Map<String,Object> MemberPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Member> memberPage=memberService.getMemberPage(request);
		map.put("memberPage", memberPage);
		map.put("code", 1);
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/memberlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Member> memberList=memberService.getMemberList(request);
		map.put("memberList", memberList);
		return map;
	}
<<<<<<< HEAD
	/*
	 * 会员头像
	 */
	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg( String id) throws Exception{

		byte[] imageContent ;
		// 根据id获取当前用户的信息
		Member member = memberService.getMemberImg(id);
		
	    //Provider provider = providerService.getProviderImg(id);
		imageContent = member.getHeadImg();
		System.out.println("图片==="+member.getHeadImg());
				        
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	/*
	 * 修改会员信息
	 */
	
	@RequestMapping("/changemember")	
	public String changMember(HttpServletRequest request, MultipartFile file,String memberid,String name, String email,String sex,String id) throws Exception{
		System.out.println("changeMember start");
		Member member = new Member();
		memberService.saveMember(member, file, request, memberid,name, email, sex, id);		            
		
		return "e-commerce_account";	
	}
	/*
	 * 修改密码
	 */
	@RequestMapping(value = "/changemima", method = RequestMethod.GET)
	public Map<String, Object> changeMima(HttpServletRequest request, String memberid){
		System.out.println("changeMima start");
		Map<String,Object> map=new HashMap<String,Object>();
		List<Member> list = memberService.getChangeMima(request, memberid);
		String oldPassword= MD5Util.getMD5(request.getParameter("oldPassword").getBytes());
		String newPassword = MD5Util.getMD5(request.getParameter("newPassword").getBytes());
		String querenPassword = MD5Util.getMD5(request.getParameter("querenPassword").getBytes());
		System.out.println("旧密码：" + oldPassword + "新密码：" +  newPassword);
		if(!newPassword.equals(querenPassword)) {
			map.put("mem", "请输入正确的新密码");
		}else if(!oldPassword.equals(list.get(0).getPassword())) {
			map.put("mem", "请输入正确的旧密码");
		}else {
			int member = memberService.doChangeMima(request, memberid);
			map.put("mem", "修改密码成功");
		}
		return map;
		
	}
	
	
	
	
	
	
=======

>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
}
