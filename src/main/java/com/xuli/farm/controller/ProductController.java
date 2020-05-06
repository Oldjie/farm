package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.dto.RestInfo;
import com.xuli.farm.po.Activities;
import com.xuli.farm.po.News;
import com.xuli.farm.po.Product;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.service.ProductService;
import com.xuli.farm.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String addProduct() {
        return "admin/add_product";
    }


    @PostMapping("admin/save_product.html")
    @ResponseBody
    public ResultInfo saveProduct(Product product) {
        ResultInfo resultInfo = null;
        Boolean flag = productService.insertProduct(product);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @PostMapping("admin/updateProduct.html")
    @ResponseBody
    public ResultInfo updateProduct(Product product) {
        ResultInfo resultInfo = null;
        Boolean flag = productService.updateProduct(product);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @GetMapping("admin/editProduct.html")
    public String editNews(Model model, @RequestParam(value = "uid") int uid) {
        Product product = productService.queryProductById(uid);
        model.addAttribute("product", product);
        return "admin/editProduct";

    }


    @PostMapping("admin/delProduct.html")
    @ResponseBody
    public ResultInfo delUser(Product product) {
        ResultInfo resultInfo = null;
        Boolean flag = productService.deleteProductById(product.getId());
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @GetMapping("products.html")

    public String products(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<Product> productPageInfo = productService.queryUserAll(pageNum, pageSize);

        model.addAttribute("products", productPageInfo);
        return "home/products";
    }

    @GetMapping("productDetails.html")
    public String productDetails(Model model, @RequestParam(value = "uid") int uid) {
        Product product = productService.queryProductById(uid);
        model.addAttribute("product", product);

        return "home/productDetails";
    }
}
