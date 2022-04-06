package com.edward.mt.service;

import com.edward.mt.bean.Dish;
import com.edward.mt.vo.MtResult;

import java.util.List;

public interface DishService {
    MtResult addDish(Dish dish);

    MtResult showDishByPage(int val,Dish dish);

    MtResult deleteDishById(int deleteId);

    MtResult findDishById(int id);

    MtResult updateDish(Dish dish);

    MtResult deleteIds(List<Integer> ids);
}
