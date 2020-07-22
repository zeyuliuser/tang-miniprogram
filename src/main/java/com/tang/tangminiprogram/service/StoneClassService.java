package com.tang.tangminiprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.tangminiprogram.po.ProductPO;
import com.tang.tangminiprogram.po.StoneClassPO;

import java.util.Map;

public interface StoneClassService extends IService<StoneClassPO> {
    Map<String, Object> addStoneClass(StoneClassPO stoneClassPO);

    Map<String, Object> deleteStoneClass(String id);
}
