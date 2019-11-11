package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.util.MD5Util;
import com.datangedu.cn.controller.id.IdGen;
import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.RegionService;


@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	MemberMapper memberMapper;
	@Resource
	RegionService rService;

<<<<<<< HEAD
=======

	/*
	 * 会员登陆
	 */

>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
	@Override
	public List<Member> login(HttpServletRequest request) {
		String cellphone =request.getParameter("cellphone"); 
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String inputCode = request.getParameter("inputCode");

		MemberExample memberExample = new MemberExample(); 
		MemberExample.Criteria criteria = memberExample.createCriteria();
	    criteria.andCellphoneEqualTo(cellphone);
		criteria.andPasswordEqualTo(request.getParameter("password"));
		
		return memberMapper.selectByExample(memberExample);
	}

<<<<<<< HEAD
=======


	/*
	 * 会员找回密码
	 */

>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
	@Override
	public List<Member> findPassword(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String inputCode = request.getParameter("inputCode");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		System.out.println(request.getParameter("cellphone"));
		System.out.println(request.getParameter("inputCode"));
		System.out.println(request.getParameter("password"));
		MemberExample memberExample = new MemberExample(); 
		MemberExample.Criteria criteria = memberExample.createCriteria();
	    criteria.andCellphoneEqualTo(cellphone);
	    
	    return memberMapper.selectByExample(memberExample);

	}
	

<<<<<<< HEAD
=======


	/*
	 * 会员注册
	 */

>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
	@Override
	public int userRegion(HttpServletRequest request) {
		String name = request.getParameter("name");
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		System.out.println(name + "," + cellphone + "，" + password + "," + province + "," + city + "," + area);
	   
	    Member member = new Member();
	    member.setId(Sequence.nextId());
	    member.setName(name);
	    member.setCellphone(cellphone);
	    member.setPassword(password);
<<<<<<< HEAD
=======

		/*
		 * member.setProvince(province); member.setCity(city); member.setArea(area);
		 */

>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
	    member.setProvince(province);
	    member.setCity(city);
	    member.setArea(area);

<<<<<<< HEAD
=======

>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
	    
		return memberMapper.insert(member);
	    }

	
<<<<<<< HEAD
=======
	@Override
	public List<Member> getMemberList(HttpServletRequest request) {
		MemberExample memberExample=new MemberExample();
		MemberExample.Criteria criteria=memberExample.createCriteria();
		memberExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		memberExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return memberMapper.selectByExample(memberExample);
	}
	@Override
	public List<Member> getMemberPage(HttpServletRequest request) {
		MemberExample memberExample=new MemberExample();
		memberExample.setLikeName(request.getParameter("name"));
		memberExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		memberExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<Member> memberPage=memberMapper.selectByLike(memberExample);
			return memberPage;
	}
>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8

}
