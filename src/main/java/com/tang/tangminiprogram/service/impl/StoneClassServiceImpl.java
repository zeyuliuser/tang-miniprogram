package com.tang.tangminiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.tangminiprogram.dao.StoneClassDao;
import com.tang.tangminiprogram.po.ProductPO;
import com.tang.tangminiprogram.po.StoneClassPO;
import com.tang.tangminiprogram.service.StoneClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("stoneClassService")
public class StoneClassServiceImpl extends ServiceImpl<StoneClassDao, StoneClassPO> implements StoneClassService {

    @Resource
    private StoneClassDao stoneClassDao;

    @Override
    public Map<String, Object> addStoneClass(StoneClassPO stoneClassPO) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        try{
            stoneClassPO.setCreateTime(new Date());
            int res = stoneClassDao.insert(stoneClassPO);
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
    public Map<String, Object> deleteStoneClass(String id) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        int isExist = stoneClassDao.countById(id);
        if(isExist == 0){
            resmap.put("code",404);
            resmap.put("info","该信息不存在或已经删除");
            return resmap;
        }
        try{
            int res = stoneClassDao.deleteById(id);
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
    public List<StoneClassPO> getStoneClassByLevel(String level) {
        return stoneClassDao.getStoneClassByLevel(level);
    }

    @Override
    public StoneClassPO getStoneClassById(String id) {
        int isExist = stoneClassDao.countById(id);
        if(isExist == 0){
            throw new RestClientException("该信息不存在或已经删除");
        }
        return stoneClassDao.selectById(id);
    }
}
