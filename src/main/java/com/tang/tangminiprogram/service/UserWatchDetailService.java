package com.tang.tangminiprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import com.tang.tangminiprogram.request.AddWatchReq;
import com.tang.tangminiprogram.request.WatchDetailPageReq;

import java.util.Map;

public interface UserWatchDetailService extends IService<UserWatchDetailPO> {

    Map<String, Object> addUserWatchDetail(AddWatchReq addWatchReq);

    PageUtils<UserWatchDetailPO> userWatchDetailList(WatchDetailPageReq watchDetailPageReq);
}
