package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.User;

public interface UserService {

	public List<User> login(HttpServletRequest request);

	public List<User> findPassword(HttpServletRequest request);

}
