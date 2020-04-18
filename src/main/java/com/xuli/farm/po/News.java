package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table
public class News {
    @Id
    private Integer id;
    private String title;
    private String subTitle;
    private String content;
    private String imgUrl;
    private String subImgUrl;
    private String created;

    public News() {
    }

    public News(Integer id, String title, String subTitle, String content, String imgUrl, String subImgUrl, String created) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.imgUrl = imgUrl;
        this.subImgUrl = subImgUrl;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSubImgUrl() {
        return subImgUrl;
    }

    public void setSubImgUrl(String subImgUrl) {
        this.subImgUrl = subImgUrl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
