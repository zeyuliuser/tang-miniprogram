package com.tang.tangminiprogram.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.dao.ProductDao;
import com.tang.tangminiprogram.po.ProductPO;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.ProductPageReq;
import com.tang.tangminiprogram.request.UserPageReq;
import com.tang.tangminiprogram.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao,ProductPO> implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public Map<String, Object> addProduct(ProductPO productPO) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        try{
            int res = productDao.insert(productPO);
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
    public Map<String, Object> deleteProduct(String id) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        int count = productDao.ifExist(id);
        if(count == 0){
            resmap.put("code",404);
            resmap.put("info","该商品不存在");
            return resmap;
        }

        try{
            int res = productDao.deleteById(id);
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
    public Map<String, Object> editProduct(ProductPO productPO) {
        Map<String,Object> resmap = new HashMap<String,Object>();
        int count = productDao.ifExist(productPO.getId());
        if(count == 0){
            resmap.put("code",404);
            resmap.put("info","该商品不存在");
            return resmap;
        }
        ProductPO oldProduct = productDao.selectById(productPO.getId());
        BeanUtils.copyProperties(productPO,oldProduct);
        try{
            int res = productDao.updateById(oldProduct);
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
    public PageUtils<ProductPO> productList(ProductPageReq productPageReq) {
        QueryWrapper<ProductPO> queryWrapper = new QueryWrapper<ProductPO>();
        Page<ProductPO> page = new Page<ProductPO>(productPageReq.getCurrent(),productPageReq.getSize());
        IPage<ProductPO> iPage = productDao.selectPage(page,queryWrapper);
        List<ProductPO> productPOList = iPage.getRecords();
        PageUtils<ProductPO> productPage = new PageUtils(iPage);
        productPage.setList(productPOList);
        return productPage;
    }

    @Override
    public ProductPO productDetail(String id) {
        return productDao.selectById(id);
    }
}
