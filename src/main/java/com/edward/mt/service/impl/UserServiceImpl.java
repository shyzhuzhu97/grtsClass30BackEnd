package com.edward.mt.service.impl;

import com.edward.mt.bean.User;
import com.edward.mt.constant.MtConstant;
import com.edward.mt.exception.MtException;
import com.edward.mt.mapper.UserMapper;
import com.edward.mt.service.UserService;
import com.edward.mt.utils.MD5utils;
import com.edward.mt.utils.UploadUtils;
import com.edward.mt.vo.MtResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public MtResult getVerifyCode() {

        return null;
    }

    @Override
    public User login(User user) {
        if ("".equals(user.getUserName())) {
            throw new MtException("用户名不能为空！");
        }
        if ("".equals(user.getPassWord())) {
            throw new MtException("密码不能为空！");
        }
        String encrypt = MD5utils.encrypt(user.getPassWord());
        user.setPassWord(encrypt);
        User u = userMapper.login(user);
        if (u == null) {
            throw new MtException("登录失败，请检查用户名及密码");
        }
        u.setPassWord(null);
        return u;
    }

    @Override
    public boolean checkData(int type, String checkData) {
        User user = userMapper.checkData(type, checkData);
        if (user != null) {
            if (type == 1) {
                throw new MtException("用户名已存在！");
            } else if (type == 2) {
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
        user.setStatus(2); //2表示注册了但是邮箱未激活
        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);
        //添加用户 user中有id了
        int count = userMapper.addUser(user);
        if (count <= 0) {
            throw new MtException("注册失败");
        }
        //发送邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //放到邮件助手对象里面去
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        //还是设置主体
        try {
            messageHelper.setSubject("激活您的帐户");
            messageHelper.setFrom("18468073661@163.com");
            messageHelper.setTo(user.getEmail());
            messageHelper.setText("<a href='http://192.168.110.87:8080/#/active?uuid=" + user.getId() + "'>点击我激活账号</a>", true);
            javaMailSender.send(messageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MtResult uploadAvatar(MultipartFile file) {
        File dateFolder = UploadUtils.getDateFolderRoot();
        if (!dateFolder.exists()) { //判断文件夹是否存在，如果不存在就创建这个文件夹
            dateFolder.mkdir();
        }
        //代码到这里一定有文件夹了
        String imgName = UploadUtils.getImgName(file.getOriginalFilename());
        //得到文件名称
        try {
            file.transferTo(new File(dateFolder, imgName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new MtException("上传图片失败");
        }

        return MtResult.ok().data("imgPath", MtConstant.HOST + "/" + UploadUtils.getDateFolder() + "/" + imgName);
    }

    @Override
    public void activeUser(int id) {
        int count = userMapper.activeUser(id);
        if(count<=0){
            throw new MtException("激活失败");
        }

    }
}
