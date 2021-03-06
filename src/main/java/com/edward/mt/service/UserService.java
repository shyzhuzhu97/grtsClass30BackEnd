package com.edward.mt.service;

import com.edward.mt.bean.User;
import com.edward.mt.vo.MtResult;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

public interface UserService {
    //生成验证码
    MtResult getVerifyCode ();
    //用户登录
    User login (User user);
    //检查用户的用户名及邮箱是否可用
    boolean checkData(int type, String checkData);

    void addUser(User user);

    MtResult uploadAvatar(MultipartFile file);

    void activeUser(int id);

    MtResult getInfo(int id);

    void updateUser(User user);
}
