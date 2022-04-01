package com.edward.mt.service;

import com.edward.mt.bean.DishCategory;
import com.edward.mt.vo.MtResult;

public interface CategoryService {


    MtResult showCategoryByPage(int currentPage);

    MtResult deleteCategoryById(int id);

    MtResult addCategory(DishCategory category);

    MtResult findCategoryById(int id);

    MtResult updateCategory(DishCategory category);
}
