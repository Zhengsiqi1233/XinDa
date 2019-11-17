package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.BusinessOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BusinessOrderMapper {
    long countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

    int deleteByPrimaryKey(String businessNo);

    int insert(BusinessOrder record);

    int insertSelective(String business_no, BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(String businessNo);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(String business_no, BusinessOrder record);
    
    List<BusinessOrder> selectByLike(BusinessOrderExample example);

	List<BusinessOrder> selectByToday(BusinessOrderExample example);

	List<BusinessOrder> selectByWeek(BusinessOrderExample example);

	List<BusinessOrder> selectByMonth(BusinessOrderExample example);

	int selectBySum();
	
	int selectByTodaySum();
	
	int selectByWeekSum();
	
	int selectByMonthSum();

	List<BusinessOrder> selectByCommon(BusinessOrderExample businessOrderExaple);

	List<BusinessOrder> selectByStop(BusinessOrderExample businessOrderExaple);

	List<BusinessOrder> selectByLikeInfo(BusinessOrderExample businessOrderExample);

	List<BusinessOrder> selectByLikeInfoStop(BusinessOrderExample businessOrderExample);

	List<BusinessOrder> selectByOther(BusinessOrderExample businessOrderExample);

	List<BusinessOrder> selectByPay(BusinessOrderExample businessOrderExample);

	List<BusinessOrder> selectNoByLike(BusinessOrderExample businessOrderExample);

	int insertByNo(String business_no, BusinessOrder businessOrder);

	int updateByNo(String business_no, String evaluate);

}