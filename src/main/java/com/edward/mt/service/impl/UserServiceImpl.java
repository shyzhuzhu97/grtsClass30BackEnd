package com.edward.mt.service.impl;

import com.edward.mt.bean.User;
import com.edward.mt.exception.MtException;
import com.edward.mt.mapper.UserMapper;
import com.edward.mt.service.UserService;
import com.edward.mt.utils.MD5utils;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MtResult getVerifyCode() {

        return null;
    }

    @Override
    public User login(User user) {
        if("".equals(user.getUserName())){
            throw new MtException("用户名不能为空！");
        }
        if("".equals(user.getPassWord())){
            throw new MtException("密码不能为空！");
        }
        String encrypt = MD5utils.encrypt(user.getPassWord());
        user.setPassWord(encrypt);
        User u = userMapper.login(user);
        if(u == null){
            throw new MtException("登录失败，请检查用户名及密码");
        }
        u.setPassWord(null);
        return u;
    }

    @Override
    public boolean checkData(int type, String checkData) {
        User user = userMapper.checkData(type,checkData);
        if(user!=null){
            if(type == 1){
                throw new MtException("用户名已存在！");
            }else if (type == 2){
                throw new MtException("邮箱已存在！");
            }
        }
        return true;
    }

    @Override
    public void addUser(User user) {
        //生成MD5加密密码
        String encrypt = MD5utils.encrypt(user.getPassWord());
        user.setPassWord(encrypt);
        //补充数据
        user.setAvatar("虚假的头像");
        user.setStatus(3); //3表示注册了但是邮箱未激活
        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);
        int count = userMapper.addUser(user);
        if (count<=0){
            throw new MtException("注册失败");
        }

    }
}
