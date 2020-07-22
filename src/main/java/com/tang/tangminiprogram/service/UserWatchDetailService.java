package com.tang.tangminiprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import com.tang.tangminiprogram.request.AddWatchReq;

import java.util.Map;

public interface UserWatchDetailService extends IService<UserWatchDetailPO> {

    Map<String, Object> addUserWatchDetail(AddWatchReq addWatchReq);
}
