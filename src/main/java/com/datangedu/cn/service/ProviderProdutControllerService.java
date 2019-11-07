package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.ProviderProdut;

public interface ProviderProdutControllerService {

	List<ProviderProdut> getProviderProdutList(HttpServletRequest request);

	int setPProviderProdutDelete(HttpServletRequest request);

	List<ProviderProdut> getProviderProdutPage(HttpServletRequest request);


}
