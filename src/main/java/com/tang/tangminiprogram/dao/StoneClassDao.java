package com.tang.tangminiprogram.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.tangminiprogram.po.StoneClassPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoneClassDao extends BaseMapper<StoneClassPO> {
    int countById(String id);
}
