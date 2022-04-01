package com.edward.mt.mapper;

import com.edward.mt.bean.DishCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<DishCategory> showDishCategoryByPage(int startIndex);

    int categoryNum();

    int deleteCategoryById(int id);

    int addCategory(DishCategory category);

    DishCategory findCategoryById(int id);

    int updateCategory(DishCategory category);

    int deleteIds(@Param("ids") List<Integer> ids);

    List<DishCategory> showCategoryAll();
}
