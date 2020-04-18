package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "food")
public class Food {

    @Id
    private Integer id;
    private String foodName;
    private String foodContent;
    private String foodImg;
    private String created;


    public Food() {
    }

    public Food(Integer id, String foodName, String foodContent, String foodImg, String created) {
        this.id = id;
        this.foodName = foodName;
        this.foodContent = foodContent;
        this.foodImg = foodImg;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodContent() {
        return foodContent;
    }

    public void setFoodContent(String foodContent) {
        this.foodContent = foodContent;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
