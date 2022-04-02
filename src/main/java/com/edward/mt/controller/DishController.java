package com.edward.mt.controller;

import com.edward.mt.bean.Dish;
import com.edward.mt.service.DishService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @RequestMapping("/addDish")
    public MtResult addDish(@RequestBody Dish dish){
        MtResult mtResult = dishService.addDish(dish);

        return mtResult;
    }

    @RequestMapping("/deleteDishById/{deleteId}")
    public MtResult addDish(@PathVariable int deleteId){
        MtResult mtResult = dishService.deleteDishById(deleteId);

        return mtResult;
    }

    @RequestMapping("/showDishByPage/{val}")
    public MtResult showDishByPage(@PathVariable int val){
        MtResult mtResult = dishService.showDishByPage(val);
        System.out.println(mtResult);
        return mtResult;
    }


}
