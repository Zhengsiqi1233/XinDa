package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.model.sysUser.ProviderProdut;

public interface ProviderProdutService {

	public List<ProviderProdut> getProdutListById(String id);

	public List<ProviderProdut> getProviderProdutChange(String id);

	public int produtInsert(HttpServletRequest request , MultipartFile file, String serviceName, String serviceInfo, String price);

<<<<<<< Updated upstream

	List<ProviderProdut> getProviderProdutList(HttpServletRequest request);

	int setPProviderProdutDelete(HttpServletRequest request);

	List<ProviderProdut> getProviderProdutPage(HttpServletRequest request);

<<<<<<< HEAD
	public List<ProviderProdut> getProdutListByLike(HttpServletRequest request, String providerid);
=======
	public int providerUpdate(HttpServletRequest request, MultipartFile file, String name, String province, String city,
			String area, String cellphone, String wechat, String qq, String email);

>>>>>>> 80103050b21413fcf7364418868f0a9ec951a22b

=======
	public int providerUpdate(HttpServletRequest request, MultipartFile file, String name, String province, String city,
			String area, String cellphone, String wechat, String qq, String email);

>>>>>>> Stashed changes
}
