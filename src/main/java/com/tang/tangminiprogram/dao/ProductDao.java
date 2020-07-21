package com.tang.tangminiprogram.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.tangminiprogram.po.ProductPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao extends BaseMapper<ProductPO> {
    int ifExist(@Param("id") String id);
}
