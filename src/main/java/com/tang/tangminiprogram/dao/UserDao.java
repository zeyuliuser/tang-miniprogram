package com.tang.tangminiprogram.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.tangminiprogram.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<UserPO> {

    int countById(@Param("id") String id);
}
