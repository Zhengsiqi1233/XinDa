package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
import com.datangedu.cn.model.sysUser.ProviderProdut;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BusinessOrderMapper {
    long countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

    int deleteByPrimaryKey(String businessNo);

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(String businessNo);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);

	List<BusinessOrder> selectByLike(BusinessOrderExample example);

	List<BusinessOrder> selectByToday(BusinessOrderExample example);

	List<BusinessOrder> selectByWeek(BusinessOrderExample example);

	List<BusinessOrder> selectByMonth(BusinessOrderExample example);

	int selectBySum();
	
	int selectByTodaySum();
	
	int selectByWeekSum();
	
	int selectByMonthSum();
}