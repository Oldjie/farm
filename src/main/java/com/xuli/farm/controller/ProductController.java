package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Activities;
import com.xuli.farm.po.Product;
import com.xuli.farm.service.ProductService;
import com.xuli.farm.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    @RequestMapping("admin/product.html")
    public String product(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<Product> pageBean = productService.queryUserAll(pageNum, pageSize);

        model.addAttribute("products", pageBean);
        return "admin/product";
    }

    @RequestMapping("admin/add_product.html")
    public String addProduct(){
        return "admin/add_product";
    }
}
