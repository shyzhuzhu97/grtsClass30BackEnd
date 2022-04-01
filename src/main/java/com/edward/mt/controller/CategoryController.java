package com.edward.mt.controller;

import com.edward.mt.bean.DishCategory;
import com.edward.mt.service.CategoryService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/showCategoryByPage/{val}")
    public MtResult showCategoryByPage(@PathVariable int val){
        MtResult mtResult = categoryService.showCategoryByPage(val);
        return mtResult;
    }

    @RequestMapping("/deleteCategoryById/{id}")
    public MtResult deleteCategoryById(@PathVariable int id){
        MtResult mtResult = categoryService.deleteCategoryById(id);
        return mtResult;
    }

    @RequestMapping("/addCategory")
    public MtResult addCategory(@RequestBody DishCategory category){
        MtResult mtResult = categoryService.addCategory(category);
        return mtResult;
    }

    @RequestMapping("/findCategoryById/{id}")
    public MtResult findCategoryById(@PathVariable int id){
        MtResult mtResult = categoryService.findCategoryById(id);
        return mtResult;
    }
    @RequestMapping("/updateCategory")
    public MtResult updateCategory(@RequestBody DishCategory category){
        MtResult mtResult = categoryService.updateCategory(category);
        return mtResult;
    }

    @RequestMapping("/deleteIds")
    public MtResult deleteIds(@RequestBody List<Integer> ids){
        MtResult result = categoryService.deleteIds(ids);
        return result;
    }


}
