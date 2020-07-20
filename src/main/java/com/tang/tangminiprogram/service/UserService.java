package com.tang.tangminiprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.UserPageReq;

import java.util.Map;

public interface UserService extends IService<UserPO> {
    /**
     * 增加浏览用户
     * */
    Map<String,Object> addUserInfo(UserPO userPO);
    /**
     * 查看浏览用户列表
     * */
    PageUtils<UserPO> watchUserList(UserPageReq userPageReq);
    /**
     * 查看浏览用户详情
     * */
    UserPO userDetail(String id);


    Map<String, Object> addManager(String id);
}
