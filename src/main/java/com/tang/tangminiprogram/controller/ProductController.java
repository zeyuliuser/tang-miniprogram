package com.tang.tangminiprogram.controller;

import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.ProductPO;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.ProductPageReq;
import com.tang.tangminiprogram.request.UserPageReq;
import com.tang.tangminiprogram.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map<String,Object> addProduct(@RequestBody ProductPO productPO){
        Map<String,Object> res = new HashMap<>();
        productPO.setCreateTime(new Date());
        res = productService.addProduct(productPO);
        return res;
    }

    @RequestMapping(value = "deleteProduct",method = RequestMethod.POST)
    public Map<String,Object> deleteProduct(String id){
        Map<String,Object> res = new HashMap<>();
        res = productService.deleteProduct(id);
        return res;
    }

    @RequestMapping(value = "editProduct",method = RequestMethod.POST)
    public Map<String,Object> editProduct(@RequestBody ProductPO productPO){
        Map<String,Object> res = new HashMap<>();
        res = productService.editProduct(productPO);
        return res;
    }

    @RequestMapping(value = "productList",method = RequestMethod.POST)
    public PageUtils<ProductPO>  productList(@RequestBody ProductPageReq productPageReq){
        return productService.productList(productPageReq);
    }

    @RequestMapping(value = "productDetail",method = RequestMethod.POST)
    public ProductPO productDetail(String id){
        return productService.productDetail(id);
    }
}
