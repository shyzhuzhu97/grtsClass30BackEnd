package com.edward.mt.service.impl;

import com.edward.mt.bean.DishCategory;
import com.edward.mt.exception.MtException;
import com.edward.mt.mapper.CategoryMapper;
import com.edward.mt.service.CategoryService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public MtResult showCategoryByPage(int currentPage) {
        int startIndex = (currentPage - 1) * 6;
        List<DishCategory> dishCategories = categoryMapper.showDishCategoryByPage(startIndex);
        int categoryNum = categoryMapper.categoryNum();
        if(dishCategories == null){
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("categoryNum",categoryNum).data("dishCategories",dishCategories);
    }
    @Override
    public MtResult showCategoryAll() {
        List<DishCategory> dishCategories = categoryMapper.showCategoryAll();
        if(dishCategories == null){
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("categories",dishCategories);
    }

    @Override
    public MtResult deleteCategoryById(int id) {
        int count = categoryMapper.deleteCategoryById(id);
        if(count<=0){
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
        if(count<=0){
            throw new MtException("添加失败请重试");
        }
        return MtResult.ok();
    }

    @Override
    public MtResult findCategoryById(int id) {
        DishCategory category = categoryMapper.findCategoryById(id);
        if (category == null){
            throw new MtException("查询失败，请重试");

        }
        return MtResult.ok().data("category",category);
    }

    @Override
    public MtResult updateCategory(DishCategory category) {
        category.setUpdated(new Date());
        int count = categoryMapper.updateCategory(category);
        if (count <=0){
            throw new MtException("修改失败，请重试");

        }
        return MtResult.ok().data("count",count);
    }

    @Override
    public MtResult deleteIds(List<Integer> ids) {
        if(ids.size()==0){
            throw new MtException("未选择删除对象");
        }
        int count = categoryMapper.deleteIds(ids);
        if (count <=0){
            throw new MtException("删除失败，请重试");

        }
        return MtResult.ok().data("count",count);
    }


}
