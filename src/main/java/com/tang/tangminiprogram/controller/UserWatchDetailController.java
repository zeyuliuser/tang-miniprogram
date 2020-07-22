package com.tang.tangminiprogram.controller;

import com.tang.tangminiprogram.request.AddWatchReq;
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
    //todo 查看列表
}
