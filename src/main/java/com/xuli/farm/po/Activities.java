package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "activities")
public class Activities {
    @Id
    private Integer id;
    private String title;
    private String content;
    private String activitiesImg;
    private String created;

    public Activities() {
    }

    public Activities(Integer id, String title, String content, String activitiesImg, String created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.activitiesImg = activitiesImg;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActivitiesImg() {
        return activitiesImg;
    }

    public void setActivitiesImg(String activitiesImg) {
        this.activitiesImg = activitiesImg;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
