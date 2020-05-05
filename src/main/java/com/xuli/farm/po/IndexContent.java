package com.xuli.farm.po;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "indexContent")
public class IndexContent {

    @Id
    private Long id;
    private String content;

    public IndexContent() {
    }

    public IndexContent(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
