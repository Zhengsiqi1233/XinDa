package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.CartMapper;
import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.CartExample;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import com.datangedu.cn.service.CartService;
@Service
public class CartServiceImpl implements CartService{
    @Resource
    CartMapper cartMapper;
    @Resource
    ProviderProdutMapper providerProdutMapper;
    /*
     * 购物车列表
     */
	@Override
	public List<Cart> getMemberCart(String memberid) {
		System.out.println("getMemberCart start");
	    CartExample cartExample = new CartExample();
	    CartExample.Criteria criteria = cartExample.createCriteria();
	    criteria.andMemberIdEqualTo(memberid);
		
		return cartMapper.selectByExample(cartExample);
	
	}
	/*
	 * 购物车添加商品
	 */
	@Override
	public int getCartAdd(String id, String memberid) {
		System.out.println("getCartAdd start");
		ProviderProdutExample providerProdutExample = new ProviderProdutExample();
		ProviderProdutExample.Criteria criteria = providerProdutExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<ProviderProdut> list = providerProdutMapper.selectByExample(providerProdutExample);
		Cart cart = new Cart();
		cart.setProdutId(list.get(0).getId());
		cart.setMemberId(memberid);
		cart.setProdutName(list.get(0).getServiceName());
		cart.setPrice(list.get(0).getPrice());
		cart.setProviderName(list.get(0).getProviderName());
		cart.setBuyNum(1);
		return cartMapper.insert(cart);
	}
	@Override
	public List<Cart> getMemberCartByName(String providerName, String memberid) {
		CartExample cartExample = new CartExample();
	    CartExample.Criteria criteria = cartExample.createCriteria();
	   // criteria.andProviderIdEqualTo(providerId);
	    criteria.andProviderNameEqualTo(providerName);
	    criteria.andMemberIdEqualTo(memberid);
		return cartMapper.selectByExample(cartExample);
	}
	/*
	 *产品数量改变
	 */
	@Override
	public List<Cart> getReduceNum(HttpServletRequest request, String produtId) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andProdutIdEqualTo(produtId);
		return cartMapper.selectByExample(cartExample);
	}
	/*
	 * 删除购物车产品
	 */
	@Override
	public int getDelCart(HttpServletRequest request,String produtId) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andProdutIdEqualTo(produtId);
		
		return cartMapper.deleteByExample(cartExample);
	}
	
	@Override
	public List<Cart> getCart(HttpServletRequest request, String memberid) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		return cartMapper.selectByExample(cartExample);
	}
	
	/*
	 * 购物车数量
	 */
	@Override
	public int getCartAll(HttpServletRequest request, String memberid) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		return cartMapper.selectAll();
	}
	
	/*
	 * 清空购物车
	 */
	@Override
	public int getCartClear(HttpServletRequest request, String memberid) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		return cartMapper.deleteByExample(cartExample);
	}
	
	
	

}
