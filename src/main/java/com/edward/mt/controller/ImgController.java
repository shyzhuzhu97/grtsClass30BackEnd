package com.edward.mt.controller;

import com.edward.mt.service.ImgService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/img")
public class ImgController {

    @Autowired
    ImgService imgService;

    //上传头像
    @PostMapping("/uploadDishImg")
    public MtResult uploadAvatar(MultipartFile file) {
        MtResult result = imgService.uploadDishImg(file);
        System.out.println(result);
        return result;
    }





}
