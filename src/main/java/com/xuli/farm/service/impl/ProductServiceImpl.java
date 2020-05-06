package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.ProductMapper;
import com.xuli.farm.po.Product;
import com.xuli.farm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo<Product> queryUserAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectAll();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public Boolean insertProduct(Product product) {
        int i = productMapper.insert(product);

        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Product queryProductById(int uid) {
        Product product = productMapper.selectByPrimaryKey(uid);
        return product;
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        int i = productMapper.deleteByPrimaryKey(id);

        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean updateProduct(Product product) {
        int i = productMapper.updateByPrimaryKey(product);
        return i == 1;
    }
}
