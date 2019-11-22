package com.datangedu.cn.service.Impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;

import com.datangedu.cn.service.ProviderProdutService;
@Service
public class ProviderProdutServiceImpl  implements ProviderProdutService{
	@Resource
	ProviderProdutMapper providerProdutMapper;
	@Resource
	ProviderMapper providerMapper;
	/*
	 * 根据服务商id获取产品
	 */
	@Override
	public List<ProviderProdut> getProdutListById(String  providerid) {
		
		System.out.println("查询用户：" + providerid);
		ProviderProdutExample providerProdutExample = new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		System.out.println("ljhgffghjkl;ldfgh098234");
		return providerProdutMapper.selectByProvider(providerid);
	}
	/*
	 * 根据服务名称获取产品的列表
	 */
	@Override
	public List<ProviderProdut> getProdutListByLike(HttpServletRequest request,String providerid) {
		ProviderProdutExample providerProdutExample = new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		providerProdutExample.setLikeName(request.getParameter("service_name"));
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<ProviderProdut> providerProdutByLike=providerProdutMapper.selectByLikeInfo(providerProdutExample);
			return providerProdutByLike;
	}
	/*
	 * 产品上线下线
	 */
	@Override
	public List<ProviderProdut> getProviderProdutChange(String produtid) {
		ProviderProdutExample providerProdutExample = new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		criteria.andIdEqualTo(produtid);
		System.out.println("查询商品id：" + produtid);
		return providerProdutMapper.selectByExample(providerProdutExample);
	}
	/*
	 * 添加服务产品
	 */
	@Override
	public int produtInsert(HttpServletRequest request, MultipartFile file, String serviceName, String serviceInfo, String price) {
		Map<Object,Object> result = new HashMap<Object,Object>();

		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer=new byte[1024];//bit---byte---1k---1m
			int len=0;
			 // 字节输出流
			 ByteArrayOutputStream bos=new ByteArrayOutputStream();
			while((len=ins.read(buffer))!=-1){
				bos.write(buffer,0,len);
			 }
			 bos.flush();
			byte data[] = bos.toByteArray();
			// 调用接口对图片进行存储
			HttpSession session =  request.getSession();
		int 	prices = Integer.parseInt(price);
		String providerid = (String) session.getAttribute("providerid");
		System.out.println("serviceName ： " + serviceName + " serviceInfo ： " + serviceInfo + " price ： " + prices);
		ProviderProdut providerProdut = new ProviderProdut();
		System.out.println("服务商id：" + providerid);
		providerProdut.setProviderId(providerid);
		providerProdut.setId(Sequence.nextId());
		providerProdut.setServiceName(serviceName);
		providerProdut.setServiceInfo(serviceInfo);
		providerProdut.setPrice(prices);
		providerProdut.setStatus(2);
	
		providerProdut.setServiceImg(data);


		return providerProdutMapper.insert(providerProdut);
		
		} catch (Exception e) {
			
			return 1;
		 }
		
	}

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
	 
	@Override
	public List<ProviderProdut> getProviderProdutBy(HttpServletRequest request) {
		
	    ProviderProdutExample providerProdutExample=new ProviderProdutExample();
	    providerProdutExample.setLikeName(request.getParameter("provider_name"));
	    System.out.println("林肯郡海关法");
		providerProdutExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerProdutExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
	    List<ProviderProdut> ProviderProdutBy=providerProdutMapper.selectByNameLike(providerProdutExample);
		return ProviderProdutBy;
	}
  
	@Override
	public List<ProviderProdut> getProviderProdutByClick(HttpServletRequest request) {
		String providerId=request.getParameter("providerId");
	    ProviderProdutExample providerProdutExample=new ProviderProdutExample();
	    ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
	    System.out.println(providerId);
	    criteria.andProviderIdEqualTo(providerId);
	    List<ProviderProdut> ProviderProdutBy=providerProdutMapper.selectByClick(providerId);
		return ProviderProdutBy;
	}
	
  	/*
	 * 修改服务商信息
	 */
	@Override
	public int providerUpdate(HttpServletRequest request, MultipartFile file,String name,  String province, String city, String area, String cellphone, String wechat, String qq, String email) {
		Map<Object,Object> result = new HashMap<Object,Object>();
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer=new byte[1024];//bit---byte---1k---1m
			int len=0;
			 // 字节输出流
			 ByteArrayOutputStream bos=new ByteArrayOutputStream();
			while((len=ins.read(buffer))!=-1){
				bos.write(buffer,0,len);
			 }
			 bos.flush();
			byte data[] = bos.toByteArray();
			// 调用接口对图片进行存储
			HttpSession session =  request.getSession();
		
		String providerid = (String) session.getAttribute("providerid");
		Provider provider = new Provider();
		provider.setId(providerid);
		provider.setName(name);
		provider.setProvince(province);
		provider.setCity(city);
		provider.setArea(area);
		provider.setCellphone(cellphone);
		provider.setWechat(wechat);
		provider.setQq(qq);
		provider.setEmail(email);
		System.out.println(provider.getName()+ "," + provider.getProvince() + "," + provider.getCity() + "," + provider.getArea() + "," + provider.getWechat() + "," + provider.getQq() + "," + provider.getEmail());
		return providerMapper.updateByPrimaryKeySelective(provider);
		
		
		} catch (Exception e) {
			
			return 1;
		 }			
	}
	/*
	 * 会员端的所有产品根据价格进行排序
	 */
	@Override
	public List<ProviderProdut> getProviderProdutListByPrice(HttpServletRequest request) {
		ProviderProdutExample providerProdutExample=new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria=providerProdutExample.createCriteria();
		providerProdutExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		providerProdutExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return providerProdutMapper.selectByPrice(providerProdutExample);
} 
	


}
