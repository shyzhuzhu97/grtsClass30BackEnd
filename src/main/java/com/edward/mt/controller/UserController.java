package com.edward.mt.controller;

import com.edward.mt.bean.User;
import com.edward.mt.service.UserService;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/verifyCode")
    public MtResult getVerifyCode(){

        return null;
    }

    @PostMapping("/login")
    public MtResult login(@RequestBody User user){
        User u = userService.login(user);
        return MtResult.ok().data("user",u);
    }
    //校验用户名及邮箱是否重复
    @RequestMapping("/checkData/{type}/{checkData}")
    public MtResult checkData(@PathVariable int type , @PathVariable String checkData){
        boolean b = userService.checkData(type,checkData);
        return MtResult.ok().data("result",b);
    }

    //上传头像
    @PostMapping("/uploadAvatar")
    public MtResult uploadAvatar(MultipartFile file) {
        MtResult result = userService.uploadAvatar(file);
        return result;
    }

    //注册
    @PostMapping("/addUser")
    public MtResult addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return MtResult.ok();
    }

    //激活账号
    @RequestMapping("/activeUser/{id}")
    public MtResult activeUser(@PathVariable int id){
        userService.activeUser(id);
        return MtResult.ok();
    }

}
