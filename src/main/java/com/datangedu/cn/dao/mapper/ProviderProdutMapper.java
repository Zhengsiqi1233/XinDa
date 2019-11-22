package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.ProviderProdutExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProviderProdutMapper {
    long countByExample(ProviderProdutExample example);

    int deleteByExample(ProviderProdutExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProviderProdut record);

    int insertSelective(ProviderProdut record);

    List<ProviderProdut> selectByExampleWithBLOBs(ProviderProdutExample example);

    List<ProviderProdut> selectByExample(ProviderProdutExample example);

    ProviderProdut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProviderProdut record, @Param("example") ProviderProdutExample example);

    int updateByExampleWithBLOBs(@Param("record") ProviderProdut record, @Param("example") ProviderProdutExample example);

    int updateByExample(@Param("record") ProviderProdut record, @Param("example") ProviderProdutExample example);

    int updateByPrimaryKeySelective(ProviderProdut record);

    int updateByPrimaryKeyWithBLOBs(ProviderProdut record);

    int updateByPrimaryKey(ProviderProdut record);


	List<ProviderProdut> selectByLike(ProviderProdutExample example);

	List<ProviderProdut> selectByLikeInfo(ProviderProdutExample providerProdutExample);

	List<ProviderProdut> selectByPrice(ProviderProdutExample providerProdutExample);

	List<ProviderProdut> selectByNameLike(ProviderProdutExample providerProdutExample);

	List<ProviderProdut> selectByClick(String providerId);

	List<ProviderProdut> selectByProvider(String providerid);
    
}