package com.tang.tangminiprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.tangminiprogram.Utils.PageUtils;
import com.tang.tangminiprogram.po.ProductPO;
import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.request.ProductPageReq;

import java.util.Map;

public interface ProductService extends IService<ProductPO> {

    Map<String, Object> addProduct(ProductPO productPO);

    Map<String, Object> deleteProduct(String id);

    Map<String, Object> editProduct(ProductPO productPO);

    PageUtils<ProductPO>  productList(ProductPageReq productPageReq);

    ProductPO productDetail(String id);
}
