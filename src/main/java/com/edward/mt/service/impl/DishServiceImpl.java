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
    public MtResult showDishByPage(int currentPage) {
        int startIndex = (currentPage - 1) * 6;
        List<Dish> dishs = dishMapper.showDishByPage(startIndex);
        int dishNum = dishMapper.dishNum();
        if (dishs == null) {
            throw new MtException("查询失败，请刷新");

        }
        return MtResult.ok().data("dishNum", dishNum).data("dishs", dishs);
    }
}
