package com.edward.mt.mapper;

import com.edward.mt.bean.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DishMapper {

    int addDish(Dish dish);

    List<Dish> showDishByPage(@Param("startIndex") int startIndex, @Param("dish") Dish dish);

    int dishNum(@Param("dish") Dish dish);

    int deleteDishById(int deleteId);

    Dish findDishById(int id);

    int updateDish(Dish dish);

    int deleteIds(@Param("ids") List<Integer> ids);
}
