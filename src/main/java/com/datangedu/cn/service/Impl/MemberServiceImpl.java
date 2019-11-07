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
		/*
		 * member.setProvince(province); member.setCity(city); member.setArea(area);
		 */

	    
		return memberMapper.insert(member);
	    }

	

}