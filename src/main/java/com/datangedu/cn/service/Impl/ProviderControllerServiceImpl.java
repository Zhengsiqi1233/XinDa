package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;


import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderExample;
import com.datangedu.cn.service.ProviderControllerService;

@Service("ProviderControllerService")
public class ProviderControllerServiceImpl implements ProviderControllerService {

	@Resource
	ProviderMapper providerMapper;
	

	/*
	 * public int setproviderregister(HttpServletRequest request) { if
	 * (request.getParameter("cellphone").length()==0 &&
	 * request.getParameter("password").length()==0) { return 2; }else if
	 * (request.getParameter("password").length()<6) { return 3; } Provider
	 * provider=new Provider(); provider.setId(request.getParameter("id"));
	 * provider.setCellphone(request.getParameter("cellphone"));
	 * provider.setPassword(request.getParameter("password")); return
	 * providerMapper.insertProvider(provider); }
	 */

	@Override
	public List<Provider> getProviderList(HttpServletRequest request) {
		ProviderExample providerExample=new ProviderExample();
		ProviderExample.Criteria criteria=providerExample.createCriteria();
		providerExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return providerMapper.selectByCommon(providerExample);
	}

	@Override
	public List<Provider> getProviderPage(HttpServletRequest request) {
		ProviderExample providerExample=new ProviderExample();
		providerExample.setLikeName(request.getParameter("name"));
		providerExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		List<Provider> providerPage=providerMapper.selectByLike(providerExample);
		return providerPage;
	}

	@Override
	public List<Provider> getProviderStop(HttpServletRequest request) {
		ProviderExample providerExample=new ProviderExample();
		ProviderExample.Criteria criteria=providerExample.createCriteria();
		providerExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return providerMapper.selectByStop(providerExample);
	}
	
}


