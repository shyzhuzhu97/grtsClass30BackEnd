package com.edward.mt.service.impl;

import com.edward.mt.bean.DishCategory;
import com.edward.mt.exception.MtException;
import com.edward.mt.mapper.CategoryMapper;
import com.edward.mt.mapper.DishMapper;
import com.edward.mt.service.CategoryService;
import com.edward.mt.vo.DishNumByCategory;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DishMapper dishMapper;

    @Override
    public MtResult showCategoryByPage(int currentPage) {
        int startIndex = (currentPage - 1) * 6;
        List<DishCategory> dishCategories = categoryMapper.showDishCategoryByPage(startIndex);
        int categoryNum = categoryMapper.categoryNum();
        if (dishCategories == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("categoryNum", categoryNum).data("dishCategories", dishCategories);
    }

    @Override
    public MtResult showCategoryAll() {
        List<DishCategory> dishCategories = categoryMapper.showCategoryAll();
        if (dishCategories == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("categories", dishCategories);
    }

    @Override
    public MtResult dishNumByCategory() {
        List<DishCategory> dishCategories = categoryMapper.showCategoryAll();

        List<Integer> parentIds = dishMapper.getParentId();

        List<DishNumByCategory> dishNum = new ArrayList<>();

        for (int i = 0; i < dishCategories.size(); i++) {
            int count = 0;
            for (int j = 0; j < parentIds.size(); j++) {
                if (parentIds.get(j) == dishCategories.get(i).getId()) {
                    count++;
                }
            }
            DishNumByCategory dishNumByCategory= new DishNumByCategory();
            dishNumByCategory.setName(dishCategories.get(i).getDishCategoryName());
            dishNumByCategory.setValue(count);
            dishNum.add(dishNumByCategory);
        }
        return MtResult.ok().data("dishNumByCategory",dishNum);
    }

    @Override
    @Transactional
    public MtResult deleteCategoryById(int id) {
        int count = categoryMapper.deleteCategoryById(id);
        dishMapper.deleteDishByParentId(id);
        if (count <= 0) {
            throw new MtException("删除失败请重试");
        }
        return MtResult.ok();
    }

    @Override
    public MtResult addCategory(DishCategory category) {
        Date date = new Date();
        category.setStatus(1);
        category.setCreated(date);
        category.setUpdated(date);
        int count = categoryMapper.addCategory(category);
        if (count <= 0) {
            throw new MtException("添加失败请重试");
        }
        return MtResult.ok();
    }

    @Override
    public MtResult findCategoryById(int id) {
        DishCategory category = categoryMapper.findCategoryById(id);
        if (category == null) {
            throw new MtException("查询失败，请重试");

        }
        return MtResult.ok().data("category", category);
    }

    @Override
    public MtResult updateCategory(DishCategory category) {
        category.setUpdated(new Date());
        int count = categoryMapper.updateCategory(category);
        if (count <= 0) {
            throw new MtException("修改失败，请重试");

        }
        return MtResult.ok().data("count", count);
    }

    @Override
    @Transactional
    public MtResult deleteIds(List<Integer> ids) {
        if (ids.size() == 0) {
            throw new MtException("未选择删除对象");
        }
        int count = categoryMapper.deleteIds(ids);
        dishMapper.deleteParentIds(ids);
        if (count <= 0) {
            throw new MtException("删除失败，请重试");

        }
        return MtResult.ok().data("count", count);
    }


}
