package com.edward.mt.controller;

import com.edward.mt.service.CategoryService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
