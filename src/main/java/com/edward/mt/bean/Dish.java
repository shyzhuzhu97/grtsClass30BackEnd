package com.edward.mt.bean;

import java.util.Date;

public class Dish {
    private int id;
    private String dishName;
    private String dishDes;
    private int price;
    private Date created;
    private Date updated;
    private String dishImg;
    private int status;
    private int buyCount;

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    private DishCategory category;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public String getDishDes() {
        return dishDes;
    }
    public void setDishDes(String dishDes) {
        this.dishDes = dishDes;
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
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public DishCategory getCategory() {
        return category;
    }
    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public String getDishImg() {
        return dishImg;
    }

    public void setDishImg(String dishImg) {
        this.dishImg = dishImg;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishDes='" + dishDes + '\'' +
                ", price=" + price +
                ", created=" + created +
                ", updated=" + updated +
                ", dishImg='" + dishImg + '\'' +
                ", status=" + status +
                ", buyCount=" + buyCount +
                '}';
    }
}
