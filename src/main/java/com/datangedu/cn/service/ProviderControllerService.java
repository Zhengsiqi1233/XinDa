package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.controller.provider.MemberComtroller;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;

public interface ProviderControllerService {

	public int setproviderlogin(HttpServletRequest request);

	public Provider loginPage(String cellphone, String password);

	public int setproviderregister(HttpServletRequest request);

	public List<Provider> getProviderList(HttpServletRequest request);

	public List<Provider> getProviderPage(HttpServletRequest request);

	public List<Provider> getProviderStop(HttpServletRequest request);
}
