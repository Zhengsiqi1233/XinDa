package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderExample;
import com.datangedu.cn.service.ProviderService;
import com.datangedu.cn.service.RegionService;
import com.datangedu.cn.util.MD5Util;
@Service
public class ProviderServiceImpl implements ProviderService{

	@Resource
	ProviderMapper providerMapper;
	@Resource
	ProviderService providerService;
	/*
	 * 服务商登陆
	 */
	@Override
	public List<Provider> login(HttpServletRequest request) {
		HttpSession session =  request.getSession();
		String cellphone =request.getParameter("cellphone"); 
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String inputCode = request.getParameter("inputCode");
		System.out.println("cellphone : " + cellphone + "password : " +  MD5Util.getMD5(request.getParameter("password").getBytes()));
		ProviderExample providerExample = new ProviderExample();
		ProviderExample.Criteria criteria = providerExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		criteria.andPasswordEqualTo(MD5Util.getMD5(request.getParameter("password").getBytes()));
		
		return providerMapper.selectByExample(providerExample);
	}
	/*
	 * 服务商找回密码
	 */
	@Override
	public List<Provider> findPassword(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String inputCode = request.getParameter("inputCode");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		System.out.println(request.getParameter("cellphone"));
		System.out.println(request.getParameter("inputCode"));
		System.out.println(request.getParameter("password"));
		ProviderExample providerExample = new ProviderExample();
		ProviderExample.Criteria criteria = providerExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		
	    return providerMapper.selectByExample(providerExample);

	}
	/*
	 * 服务商注册
	 */

	@Override
	public int providerRegion(HttpServletRequest request) {
		System.out.println("providerRegion start");
		String name = request.getParameter("name");
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		System.out.println("name " + name + "," + cellphone + "，" + password + "," + province + "," + city + "," + area);
	    Provider provider  = new Provider();
	    provider.setId(Sequence.nextId());
	    provider.setName(name);
	    provider.setCellphone(cellphone);
	    provider.setPassword(password);
	    provider.setProvince(province);
	    provider.setCity(city);
	    provider.setArea(area);

		return providerMapper.insert(provider);
	    }
	/*
	 * 获取服务商信息
	 */
	@Override
	public List<Provider> getProviderMessage(String providerid) {
		System.out.println(" getProviderListById start");
		System.out.println("服务商id ： " + providerid);
		ProviderExample providerExample = new ProviderExample();
		ProviderExample.Criteria criteria = providerExample.createCriteria();
		criteria.andIdEqualTo(providerid);
		return providerMapper.selectByExample(providerExample);
	}
	
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
	/*
	 * 店铺信息
	 */
	@Override
	public List<Provider> getProviderStore(String providerid) {
		ProviderExample providerExample = new ProviderExample();
		ProviderExample.Criteria criteria = providerExample.createCriteria();
		criteria.andIdEqualTo(providerid);
		return providerMapper.selectByExample(providerExample);
		
	}
	@Override
	public void saveUserImg(Provider provider) throws Exception {
			int i = providerMapper.saveUserImg(provider);
			if(i!=1) {
				throw new Exception("更新用户头像失败");
			}
		}
	/*
	 * 服务商头像
	 */
	@Override
	public Provider getProviderImg(String id) {
		return providerMapper.selectByPrimaryKey(id);

		
	}

		
	


}
