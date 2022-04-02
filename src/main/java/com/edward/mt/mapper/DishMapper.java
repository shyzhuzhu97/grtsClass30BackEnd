package com.edward.mt.mapper;

import com.edward.mt.bean.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {

    int addDish(Dish dish);

    List<Dish> showDishByPage(int startIndex);

    int dishNum();

    int deleteDishById(int deleteId);
}
