package com.edward.mt.bean;

import java.util.Date;

public class DishCategory {
    private int id;
    private String dishCategoryName;
    private Date created;
    private Date updated;
    private String dishCategoryDes;
    private int status;
    @Override
    public String toString() {
        return "DishCategoryService [id=" + id + ", dishCategoryName=" + dishCategoryName + ", created=" + created
                + ", updated=" + updated + ", dishCategoryDes=" + dishCategoryDes + ", status=" + status + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDishCategoryName() {
        return dishCategoryName;
    }
    public void setDishCategoryName(String dishCategoryName) {
        this.dishCategoryName = dishCategoryName;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    public String getDishCategoryDes() {
        return dishCategoryDes;
    }
    public void setDishCategoryDes(String dishCategoryDes) {
        this.dishCategoryDes = dishCategoryDes;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
