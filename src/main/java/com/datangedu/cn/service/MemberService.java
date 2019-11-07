package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Member;

public interface MemberService {

	public List<Member> login(HttpServletRequest request);

	public List<Member> findPassword(HttpServletRequest request);
	
	public int userRegion(HttpServletRequest request);
	List<Member> getMemberList(HttpServletRequest request);

	List<Member> getMemberPage(HttpServletRequest request);
	

}
