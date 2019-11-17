package com.datangedu.cn.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.BusinessOrderMapper;
import com.datangedu.cn.dao.mapper.CartMapper;
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
<<<<<<< HEAD
=======
import com.datangedu.cn.model.sysUser.Cart;
import com.datangedu.cn.model.sysUser.CartExample;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.ProviderProdut;
>>>>>>> 80103050b21413fcf7364418868f0a9ec951a22b
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import com.datangedu.cn.service.BusinessOrderService;
import com.datangedu.cn.service.ProviderProdutService;

@Service
public class BusinessOrderServiceImpl implements BusinessOrderService{
	@Resource
	BusinessOrderMapper businessOrderMapper;
	@Resource
	CartMapper cartMapper;
	@Resource
	ProviderProdutMapper providerProdutMapper;
	@Resource
	MemberMapper memberMapper;
	@Resource
	ProviderProdutService providerProdutService;
	/*
	 * 根据服务商id获取订单
	 */
	@Override
	public List<BusinessOrder> getBusinessOrderListById(String providerid) {
		System.out.println("getBusinessOrder start");
		BusinessOrderExample businessOrderExaple = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExaple.createCriteria();
<<<<<<< Updated upstream
		System.out.println("providerid : " + providerid);
=======

>>>>>>> Stashed changes
		criteria.andProviderIdEqualTo(providerid);
<<<<<<< HEAD
		return businessOrderMapper.selectByCommon(businessOrderExaple);
=======

		return businessOrderMapper.selectByExample(businessOrderExaple);
>>>>>>> 80103050b21413fcf7364418868f0a9ec951a22b
	}
	
	@Override
	public List<BusinessOrder> getBusinessOrderListByIdStop(String providerid) {
		BusinessOrderExample businessOrderExaple = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExaple.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		return businessOrderMapper.selectByStop(businessOrderExaple);
	}
	
	@Override
	public List<BusinessOrder> getBussinessOrderLike(HttpServletRequest request,String providerid) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExample.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		businessOrderExample.setLikeName(request.getParameter("order_info"));
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<BusinessOrder> bussinessOrderLike=businessOrderMapper.selectByLikeInfo(businessOrderExample);
			return bussinessOrderLike;
	}
	
	@Override
	public List<BusinessOrder> getBussinessOrderLikeStop(HttpServletRequest request,String providerid) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExample.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		businessOrderExample.setLikeName(request.getParameter("order_info"));
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<BusinessOrder> bussinessOrderLikeStop=businessOrderMapper.selectByLikeInfoStop(businessOrderExample);
			return bussinessOrderLikeStop;
	}
	
	@Override
	public List<BusinessOrder> getBussinessOrderList(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//criteria.andMemberIdEqualTo(memberid);
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByOther(businessOrderExample);
	}

	@Override
	public int setOrderDelete(HttpServletRequest request) {
		String business_no=request.getParameter("business_no");
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		criteria.andBusinessNoEqualTo(business_no);
		return businessOrderMapper.deleteByPrimaryKey(business_no);
	}
	@Override
	public List<BusinessOrder> getBussinessOrderPay(String business_no) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		criteria.andBusinessNoEqualTo(business_no);
        return businessOrderMapper.selectByPay(businessOrderExample);
	}
	@Override
	public int evaluateInsert(HttpServletRequest request) {
		String business_no=request.getParameter("business_no");
		String evaluate=request.getParameter("evaluate");
		System.out.println(business_no);
		System.out.println(evaluate);
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		criteria.andBusinessNoEqualTo(business_no);
		//BusinessOrder businessOrder=new BusinessOrder();
		//businessOrder.setEvaluate(evaluate);
		return businessOrderMapper.updateByNo(business_no,evaluate);
	}
	
	@Override
	public List<BusinessOrder> getBussinessNoLike(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		businessOrderExample.setLikeName(request.getParameter("business_no"));
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<BusinessOrder> bussinessNoLike=businessOrderMapper.selectNoByLike(businessOrderExample);
			return bussinessNoLike;
	}
	
	@Override
	public List<BusinessOrder> getBussinessOrderPage(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		businessOrderExample.setLikeName(request.getParameter("business_no"));
		businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		    List<BusinessOrder> bussinessOrderPage=businessOrderMapper.selectByLike(businessOrderExample);
			return bussinessOrderPage;
	}

	@Override
	public List<BusinessOrder> getBussinessOrderToday(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByToday(businessOrderExample);
	}

	@Override
	public List<BusinessOrder> getBussinessOrderWeek(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByWeek(businessOrderExample);
	}

	@Override
	public List<BusinessOrder> getBussinessOrderMonth(HttpServletRequest request) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria=businessOrderExample.createCriteria();
		//businessOrderExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		//businessOrderExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return businessOrderMapper.selectByMonth(businessOrderExample);
	}

	@Override
	public int getBussinessOrderSum(HttpServletRequest request) {
		return businessOrderMapper.selectBySum();
	}

	@Override
	public int getBussinessOrderTodaySum(HttpServletRequest request) {
		return businessOrderMapper.selectByTodaySum();
	}

	@Override
	public int getBussinessOrderWeekSum(HttpServletRequest request) {
		return businessOrderMapper.selectByWeekSum();
	}

	@Override
	public int getBussinessOrderMonthSum(HttpServletRequest request) {
		return businessOrderMapper.selectByMonthSum();
	}
	/*
	 * 生成订单
	 */
	@Override
	public List<BusinessOrder> getBusinessOrderInsert(HttpServletRequest request,String memberid, String memberName) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		List<Cart> list = cartMapper.selectByExample(cartExample);
		String aa = "";
		String bb = "";
		String cc = "";
		for(int i = 0; i< list.size(); i++) {
			list.get(i).getProdutId();
			list.get(i).getProdutName();
			list.get(i).getBuyNum();
			ProviderProdutExample providerProdutExample = new ProviderProdutExample();
			ProviderProdutExample.Criteria criteria3 = providerProdutExample.createCriteria();
			criteria3.andIdEqualTo(list.get(i).getProdutId());
			List<ProviderProdut> produt = providerProdutMapper.selectByExample(providerProdutExample);

			bb += produt.get(0).getProviderId() + ",";
			aa += list.get(i).getProdutId() + "*" + list.get(i).getBuyNum() + ",";
			cc += list.get(i).getProdutId() + ",";
			System.out.println(cc);
		}
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria1 = memberExample.createCriteria();
		criteria1.andIdEqualTo(memberid);
		
		List<Member> member = memberMapper.selectByExample(memberExample);
		BusinessOrder businessOrder = new BusinessOrder();
		businessOrder.setMemberId(memberid);
		businessOrder.setMemberName(member.get(0).getName());
		businessOrder.setMemberCellphone(member.get(0).getCellphone());
		businessOrder.setStatus(2);
		businessOrder.setBusinessNo(Sequence.nextId());
		businessOrder.setCreateTime(new Date());
		aa = aa.substring(0, aa.lastIndexOf(","));
		bb = bb.substring(0, bb.lastIndexOf(","));
		cc = cc.substring(0, cc.lastIndexOf(","));
		businessOrder.setOrderInfo(aa);
		businessOrder.setProviderId(bb);
		businessOrder.setProdutId(cc);
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
		int a = businessOrderMapper.insert(businessOrder);
		
		//businessOrder.setOrderInfo(info);
		
		BusinessOrderExample businessOrderExample1= new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria2 = businessOrderExample1.createCriteria();
		criteria2.andBusinessNoEqualTo(businessOrder.getBusinessNo());
		return businessOrderMapper.selectByExample(businessOrderExample1);
		
	}
	@Override
	public List<BusinessOrder> getBusinessOrderByMemberId(HttpServletRequest request, String memberid) {
		BusinessOrderExample businessOrderExaple = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExaple.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		return  businessOrderMapper.selectByExample(businessOrderExaple);
	}
	/*
	 * 支付
	 */
	@Override
	public int getBusinessPay(HttpServletRequest request, String businessNo, String val) {
		BusinessOrderExample businessOrderExaple = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExaple.createCriteria();
		criteria.andBusinessNoEqualTo(businessNo);
		BusinessOrder businessOrder = new BusinessOrder();
		int type = Integer.parseInt(val);
		businessOrder.setPayType(type);
		businessOrder.setStatus(1);
		businessOrder.setBusinessNo(businessNo);
		return businessOrderMapper.updateByPrimaryKeySelective(businessOrder);
	}
	
	@Override
	public List<Cart> getBusinessOrderName(String temp1) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andProdutIdEqualTo(temp1);
		return cartMapper.selectByExample(cartExample);
	}
	


}
