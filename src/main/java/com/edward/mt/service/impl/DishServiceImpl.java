package com.edward.mt.service.impl;

import com.edward.mt.bean.Dish;
import com.edward.mt.exception.MtException;
import com.edward.mt.mapper.DishMapper;
import com.edward.mt.service.DishService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishMapper dishMapper;

    @Override
    public MtResult addDish(Dish dish) {
        Date date = new Date();
        dish.setCreated(date);
        dish.setUpdated(date);
        dish.setStatus(1);
        int count = dishMapper.addDish(dish);
        if (count <= 0) {
            throw new MtException("添加失败，请重试");

        }
        return MtResult.ok().data("count", count);
    }

    @Override
    public MtResult showDishByPage(int currentPage, Dish dish) {
        int startIndex = (currentPage - 1) * 5;
        List<Dish> dishs = dishMapper.showDishByPage(startIndex, dish);
        int dishNum = dishMapper.dishNum(dish);
        if (dishs == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("dishNum", dishNum).data("dishs", dishs);
    }

    @Override
    public MtResult deleteDishById(int deleteId) {
        int count = dishMapper.deleteDishById(deleteId);
        if (count <= 0) {
            throw new MtException("删除失败请重试");
        }
        return MtResult.ok();
    }

    @Override
    public MtResult findDishById(int id) {
        Dish dish = dishMapper.findDishById(id);
        if (dish == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("dish", dish);
    }

    @Override
    public MtResult updateDish(Dish dish) {
        dish.setUpdated(new Date());
        int count = dishMapper.updateDish(dish);
        if (count <= 0) {
            throw new MtException("修改失败，请重试");

        }
        return MtResult.ok().data("count", count);
    }

    @Override
    public MtResult deleteIds(List<Integer> ids) {
        if (ids.size() == 0) {
            throw new MtException("未选择删除对象");
        }
        int count = dishMapper.deleteIds(ids);
        if (count <= 0) {
            throw new MtException("删除失败，请重试");

        }
        return MtResult.ok().data("count", count);
    }

    @Override
    public MtResult showDishAll() {
        List<Dish> dishs = dishMapper.showDishAll();
        if (dishs == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("dishs", dishs);
    }

    @Override
    public MtResult priceRange() {
        List<Integer> prices = dishMapper.getPrices();
        int range[] = new int[4];
        for (Integer price : prices) {
            if (price > 0 && price <= 20) {
                range[0]++;
            }else if(price > 20 && price <= 50){
                range[1]++;
            }else if(price > 50 && price <= 100){
                range[2]++;
            }else {
                range[3]++;
            }
        }
        return MtResult.ok().data("range", range);
    }
}
