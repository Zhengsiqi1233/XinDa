package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.MemberMapper;

import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import com.datangedu.cn.service.MemberControllerService;

@Service("MemberControllerService")
public class MemberControllerServiceImpl implements MemberControllerService {

	@Resource
	MemberMapper memberMapper;
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

}
