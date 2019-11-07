package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.BusinessOrderMapper;
import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
import com.datangedu.cn.service.BusinessOrderService;
@Service
public class BusinessOrderServiceImpl implements BusinessOrderService{
	@Resource
	BusinessOrderMapper businessOrderMapper;
	/*
	 * 根据服务商id获取订单
	 */
	@Override
	public List<BusinessOrder> getBusinessOrderList(String providerid) {
		BusinessOrderExample businessOrderExaple = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExaple.createCriteria();
		criteria.andProviderIdEqualTo(providerid);
		return businessOrderMapper.selectByExample(businessOrderExaple);
	}

}
