package com.edward.mt.controller;

import com.edward.mt.bean.Dish;
import com.edward.mt.service.DishService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping("/showDishAll")
    public MtResult showDishAll(){
        MtResult mtResult = dishService.showDishAll();

        return mtResult;
    }


    @RequestMapping("/priceRange")
    public MtResult priceRange(){
        MtResult mtResult = dishService.priceRange();
        return mtResult;
    }

    @RequestMapping("/deleteDishById/{deleteId}")
    public MtResult addDish(@PathVariable int deleteId){
        MtResult mtResult = dishService.deleteDishById(deleteId);

        return mtResult;
    }

    @RequestMapping("/showDishByPage/{val}")
    public MtResult showDishByPage(@PathVariable int val, @RequestBody Dish dish){
        MtResult mtResult = dishService.showDishByPage(val,dish);

        return mtResult;
    }

    @RequestMapping("/findDishById/{id}")
    public MtResult findDishById(@PathVariable int id){
        MtResult mtResult = dishService.findDishById(id);

        return mtResult;
    }

    @RequestMapping("/updateDish")
    public MtResult updateDish(@RequestBody Dish dish){
        MtResult mtResult = dishService.updateDish(dish);

        return mtResult;
    }
    @RequestMapping("/deleteIds")
    public MtResult deleteIds(@RequestBody List<Integer> ids){
        MtResult result = dishService.deleteIds(ids);
        return result;
    }


}
