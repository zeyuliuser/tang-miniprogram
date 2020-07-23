package com.tang.tangminiprogram.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.tangminiprogram.po.StoneClassPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoneClassDao extends BaseMapper<StoneClassPO> {
    int countById(@Param("id") String id);

    List<StoneClassPO> getStoneClassByLevel(@Param("level") String level);
}
