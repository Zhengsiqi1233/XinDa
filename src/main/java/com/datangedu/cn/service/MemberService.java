package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.model.sysUser.Member;

public interface MemberService {

	public List<Member> login(HttpServletRequest request);

	public List<Member> findPassword(HttpServletRequest request);
	
	public int userRegion(HttpServletRequest request);

	
	List<Member> getMemberList(HttpServletRequest request);

	List<Member> getMemberPage(HttpServletRequest request);

	public List<Member> getMemberCart(String memberid);

	public Member getMemberImg(String id);

	public int getMemberChange(HttpServletRequest request, MultipartFile file);

	public int  saveMember(Member member,  MultipartFile file,HttpServletRequest request, String memberid,String name, String email,String sex,String id) throws Exception;

	public List<Member> getChangeMima(HttpServletRequest request, String memberid);

	public int doChangeMima(HttpServletRequest request, String memberid);

	

}
