package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.Member;

public interface CartService {

	public List<Cart> getMemberCart(String memberid);

	public int getCartAdd(String id, String memberid);

	public List<Cart> getMemberCartByName(String providerId, String memberid);

	public List<Cart> getReduceNum(HttpServletRequest request, String produtId);

	public int getDelCart(HttpServletRequest request, String produtId);

	public List<Cart> getCart(HttpServletRequest request, String memberid);

	public int getCartAll(HttpServletRequest request, String memberid);

	public int getCartClear(HttpServletRequest request, String memberid);

}
