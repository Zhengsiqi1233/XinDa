package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Member;

public interface MemberService {

	public List<Member> login(HttpServletRequest request);

	public List<Member> findPassword(HttpServletRequest request);
	
	public int userRegion(HttpServletRequest request);
<<<<<<< HEAD
	
	List<Member> getMemberList(HttpServletRequest request);

	List<Member> getMemberPage(HttpServletRequest request);

	public List<Member> getMemberCart(String memberid);
=======
<<<<<<< HEAD
=======
	List<Member> getMemberList(HttpServletRequest request);

	List<Member> getMemberPage(HttpServletRequest request);
>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
>>>>>>> b7a05bcfa47b76e291a5e39f9b2feec3440c0dd4
	

}
