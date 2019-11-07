  package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import com.datangedu.cn.service.ProviderProdutControllerService;

@Service("ProviderProdutControllerService")
public class ProviderProdutControllerServiceImpl implements ProviderProdutControllerService {

	@Resource
	ProviderProdutMapper providerProdutMapper;
	@Override
	public List<ProviderProdut> getProviderProdutList(HttpServletRequest request) {
		ProviderProdutExample providerProdutExample=new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		providerProdutExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerProdutExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return providerProdutMapper.selectByExample(providerProdutExample);
	} 
	@Override
	public int setPProviderProdutDelete(HttpServletRequest request) {
		String id=request.getParameter("id");
		ProviderProdutExample providerProdutExample=new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		criteria.andIdEqualTo(id);
		return providerProdutMapper.deleteByExample(providerProdutExample);
	}
	@Override
	public List<ProviderProdut> getProviderProdutPage(HttpServletRequest request) {
		
	    ProviderProdutExample providerProdutExample=new ProviderProdutExample();
	    providerProdutExample.setLikeName(request.getParameter("service_name"));
		providerProdutExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerProdutExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
	    List<ProviderProdut> providerProdutPage=providerProdutMapper.selectByLike(providerProdutExample);
		return providerProdutPage;
	}

}
