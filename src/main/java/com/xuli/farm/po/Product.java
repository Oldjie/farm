package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "product")
public class Product {
    @Id
    private Integer id;
    private String productName;
    private String productContent;
    private String productPrice;
    private String productImg;
    private String created;


    public Product() {
    }

    public Product(Integer id, String productName, String productContent, String productPrice, String productImg, String created) {
        this.id = id;
        this.productName = productName;
        this.productContent = productContent;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
