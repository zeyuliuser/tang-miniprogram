package com.tang.tangminiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.tangminiprogram.dao.UserDao;
import com.tang.tangminiprogram.dao.UserWatchDetailDao;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import com.tang.tangminiprogram.request.AddWatchReq;
import com.tang.tangminiprogram.service.UserService;
import com.tang.tangminiprogram.service.UserWatchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("userWatchDetailService")
public class UserWatchDetailServiceImpl extends ServiceImpl<UserWatchDetailDao, UserWatchDetailPO> implements UserWatchDetailService {
    @Resource
    private UserWatchDetailDao userWatchDetailDao;
    @Resource
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Override
    public Map<String, Object> addUserWatchDetail(AddWatchReq addWatchReq) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        if(StringUtils.isEmpty(StringUtils.isEmpty(addWatchReq.getUserWatchDetailPO().getProductId()))){
            resmap.put("code",400);
            resmap.put("info","非法字段");
            return resmap;
        }
        int isExist = userDao.countById(addWatchReq.getUserPO().getId());
        if(isExist == 0){
            userService.addUserInfo(addWatchReq.getUserPO());
            String id = userDao.findThisId();
            addWatchReq.setUserPO(userDao.selectById(id));
            addWatchReq.getUserWatchDetailPO().setUserId(id);
        }
        try{
            addWatchReq.getUserWatchDetailPO().setClickTime(new Date());
            int res = userWatchDetailDao.insert(addWatchReq.getUserWatchDetailPO());
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
}
