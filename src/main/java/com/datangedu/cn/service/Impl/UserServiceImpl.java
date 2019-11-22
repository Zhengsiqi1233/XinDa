package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.dao.mapper.UserMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderExample;
import com.datangedu.cn.model.sysUser.User;
import com.datangedu.cn.model.sysUser.UserExample;
import com.datangedu.cn.service.ProviderService;
import com.datangedu.cn.service.RegionService;
import com.datangedu.cn.service.UserService;
import com.datangedu.cn.util.MD5Util;
@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserMapper userMapper;
	@Resource
	UserService userService;
	/*
	 * 管理员登陆
	 */
	@Override
	public List<User> login(HttpServletRequest request) {
		HttpSession session =  request.getSession();
		String cellphone =request.getParameter("cellphone"); 
//		String password=request.getParameter("password");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String inputCode = request.getParameter("inputCode");
		System.out.println("cellphone : " + cellphone + "password : " + password);
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		//criteria.andPasswordEqualTo(MD5Util.getMD5(request.getParameter("password").getBytes()));
		criteria.andPasswordEqualTo(password);
		return userMapper.selectByExample(userExample);
	}
	/*
	 * 管理员找回密码
	 */
	@Override
	public List<User> findPassword(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String inputCode = request.getParameter("inputCode");
		String password=request.getParameter("password");
		//String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		System.out.println(request.getParameter("cellphone"));
		System.out.println(request.getParameter("inputCode"));
		System.out.println(request.getParameter("password"));
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		
	    return userMapper.selectByExample(userExample);

	}
	

}
