package com.xuli.farm.po;


import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table
public class Feedback {
    @Id
    private Integer id;
    private Integer uid;
    private String username;
    private String message;

    private Date datetime;

    public Feedback() {

    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Feedback(Integer id, Integer uid, String message) {
        this.id = id;
        this.uid = uid;
        this.message = message;
    }
}
