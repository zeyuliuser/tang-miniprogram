package com.tang.tangminiprogram.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.UserPageReq;
import com.tang.tangminiprogram.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody UserPO userPO){
        Map<String,Object> res = new HashMap<>();
        userPO.setLevel(4);
        userPO.setCreateTime(new Date());
        res = userService.addUserInfo(userPO);
        return res;
    }

    @RequestMapping(value = "watchUserList",method = RequestMethod.POST)
    public PageUtils<UserPO> watchUserList(@RequestBody UserPageReq userPageReq){
        return userService.watchUserList(userPageReq);
    }

    @RequestMapping(value = "userDetail",method = RequestMethod.POST)
    public UserPO userDetail(String id){
        return userService.userDetail(id);
    }

    @RequestMapping(value = "addManager",method = RequestMethod.POST)
    public Map<String,Object> addManager(String id){
        return userService.addManager(id);
    }
}
