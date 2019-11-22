package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.model.sysUser.ProviderProdut;

public interface ProviderProdutService {

	public List<ProviderProdut> getProdutListById(String id);

	public List<ProviderProdut> getProviderProdutChange(String id);

	public int produtInsert(HttpServletRequest request , MultipartFile file, String serviceName, String serviceInfo, String price);



	List<ProviderProdut> getProviderProdutList(HttpServletRequest request);

	int setProviderProdutDelete(HttpServletRequest request, String produtid);

	List<ProviderProdut> getProviderProdutPage(HttpServletRequest request);


	public List<ProviderProdut> getProdutListByLike(HttpServletRequest request, String providerid);

	public int providerUpdate(HttpServletRequest request, MultipartFile file, String name, String province, String city,
			String area, String cellphone, String wechat, String qq, String email);

<<<<<<< HEAD
	public ProviderProdut getProviderProdutInfo(String id);

=======
	public List<ProviderProdut> getProviderProdutListByPrice(HttpServletRequest request);

	public List<ProviderProdut> getProviderProdutBy(HttpServletRequest request);

	public List<ProviderProdut> getProviderProdutByClick(HttpServletRequest request);
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b


}
