package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Product;



public interface ProductService {
    PageInfo<Product> queryUserAll(int pageNum, int pageSize);

    Boolean insertProduct(Product product);

    Product queryProductById(int uid);

    Boolean deleteProductById(Integer id);

    Boolean updateProduct(Product product);
}
