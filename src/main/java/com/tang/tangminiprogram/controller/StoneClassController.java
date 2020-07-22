package com.tang.tangminiprogram.controller;

import com.tang.tangminiprogram.po.StoneClassPO;
import com.tang.tangminiprogram.service.StoneClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("stoneClass")
public class StoneClassController {
    @Autowired
    private StoneClassService stoneClassService;

    @RequestMapping(value = "addStoneClass",method = RequestMethod.POST)
    public Map<String,Object> addStoneClass(@RequestBody StoneClassPO stoneClassPO){
        return stoneClassService.addStoneClass(stoneClassPO);
    }

    @RequestMapping(value = "deleteStoneClass",method = RequestMethod.POST)
    public Map<String,Object> deleteStoneClass(String id){
        return stoneClassService.deleteStoneClass(id);
    }

    //todo 查看列表
}
