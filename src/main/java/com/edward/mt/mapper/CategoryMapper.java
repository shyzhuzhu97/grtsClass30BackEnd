package com.edward.mt.mapper;

import com.edward.mt.bean.DishCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<DishCategory> showDishCategoryByPage(int startIndex);

    int categoryNum();
}
