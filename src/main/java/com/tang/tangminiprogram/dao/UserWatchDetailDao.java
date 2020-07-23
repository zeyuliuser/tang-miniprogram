package com.tang.tangminiprogram.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWatchDetailDao extends BaseMapper<UserWatchDetailPO> {

    IPage<UserWatchDetailPO> userWatchDetailList(Page<UserWatchDetailPO> page);
}
