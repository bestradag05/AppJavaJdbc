package com.ironman.persistence.entity;

import java.time.LocalDateTime;

public class Category {
    // Atributs

    private long id;
    private String name;
    private String description;
    private String urlKey;
    private String state;
    private LocalDateTime createAt;
    private LocalDateTime  updateAt;

    //Constructors

    public Category() {
    }

    public Category(long id, String name, String description, String urlKey, String state, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlKey = urlKey;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    //Enccapsulations o methods


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
