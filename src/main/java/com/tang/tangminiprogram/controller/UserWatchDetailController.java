package com.tang.tangminiprogram.controller;

import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import com.tang.tangminiprogram.request.AddWatchReq;
import com.tang.tangminiprogram.request.WatchDetailPageReq;
import com.tang.tangminiprogram.service.UserWatchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("userWatchDetail")
public class UserWatchDetailController {
    @Autowired
    private UserWatchDetailService userWatchDetailService;

    @RequestMapping(value = "addUserWatchDetail",method = RequestMethod.POST)
    public Map<String,Object> addUserWatchDetail(@RequestBody AddWatchReq addWatchReq){
        return userWatchDetailService.addUserWatchDetail(addWatchReq);
    }
    @RequestMapping(value = "userWatchDetailList",method = RequestMethod.POST)
    public PageUtils<UserWatchDetailPO> userWatchDetailList(@RequestBody WatchDetailPageReq watchDetailPageReq){
        return userWatchDetailService.userWatchDetailList(watchDetailPageReq);
    }
}
