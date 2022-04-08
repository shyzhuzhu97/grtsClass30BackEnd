package com.edward.mt.vo;

public class DishNumByCategory {
    private int value; //分类下菜品的数量
    private String name; //分类名称

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DishNumByCategory{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
