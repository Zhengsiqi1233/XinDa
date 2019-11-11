package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Member;

public interface MemberControllerService {

	List<Member> getMemberList(HttpServletRequest request);

	List<Member> getMemberPage(HttpServletRequest request);

}
