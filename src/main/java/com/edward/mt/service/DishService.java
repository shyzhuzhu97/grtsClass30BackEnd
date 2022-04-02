package com.edward.mt.service;

import com.edward.mt.bean.Dish;
import com.edward.mt.vo.MtResult;

public interface DishService {
    MtResult addDish(Dish dish);

    MtResult showDishByPage(int val);

    MtResult deleteDishById(int deleteId);
}
