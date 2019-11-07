package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Provider;

public interface ProviderService {

	public List<Provider> login(HttpServletRequest request);

	public List<Provider> findPassword(HttpServletRequest request);

	public int providerRegion(HttpServletRequest request);

	

	public List<Provider> getProviderMessage(String providerid);

	

}
