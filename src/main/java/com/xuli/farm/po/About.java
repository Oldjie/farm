package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "about")
public class About {
    @Id
    private Integer id;
    private String title;
    private String content;
    private String date;
    private String subTitle;

    public String getSubTitle() {
        return subTitle;
    }

    public About(Integer id, String title, String content, String date, String subTitle) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.subTitle = subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public About() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
