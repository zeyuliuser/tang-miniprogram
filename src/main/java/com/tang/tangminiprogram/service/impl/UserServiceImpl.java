package com.tang.tangminiprogram.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.dao.UserDao;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.UserPageReq;
import com.tang.tangminiprogram.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao,UserPO> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Map<String,Object> addUserInfo(UserPO userPO) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        try{
            int res = userDao.insert(userPO);
            if(res == 1){
                resmap.put("code",res);
                return resmap;
            }else{
                resmap.put("code",res);
                return resmap;
            }
        }catch (Exception e){
            resmap.put("code",400);
            resmap.put("info",e);
            return resmap;
        }
    }

    @Override
    public PageUtils<UserPO> watchUserList(UserPageReq userPageReq) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<UserPO>();
        Page<UserPO> page = new Page<UserPO>(userPageReq.getCurrent(),userPageReq.getSize());
        IPage<UserPO> iPage = userDao.selectPage(page,queryWrapper);
        List<UserPO> userPOList = iPage.getRecords();
        PageUtils<UserPO> userPage = new PageUtils<>(iPage);
        userPage.setList(userPOList);
        return userPage;
    }

    @Override
    public UserPO userDetail(String id) {
        return userDao.selectById(id);
    }

    @Override
    public Map<String, Object> addManager(String id) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        try{
            int res = userDao.countById(id);
            if(res == 1){
                UserPO userPO = userDao.selectById(id);
                userPO.setLevel(1);
                userDao.updateById(userPO);
                resmap.put("code",res);
                return resmap;
            }else{
                resmap.put("code",res);
                resmap.put("info","不存在该用户");
                return resmap;
            }
        }catch (Exception e){
            resmap.put("code",400);
            resmap.put("info",e);
            return resmap;
        }
    }
}
