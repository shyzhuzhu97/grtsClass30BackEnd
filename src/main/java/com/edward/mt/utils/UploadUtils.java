package com.edward.mt.utils;

import com.edward.mt.constant.MtConstant;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UploadUtils {
    //得到当前日期的String
    public static String getDateFolder() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFolderName = format.format(date);//得到文件夹名称
        return dateFolderName;
    }

    public static File getDateFolderRoot() { //类不自动加public 要手动加
        File folderPath = new File(MtConstant.IMGPATH); //根据图片服务器路径创建file对象
        String dateFolder = UploadUtils.getDateFolder();
        return new File(folderPath, dateFolder); //传入图片服务器路径、文件夹名称创建file对象
    }

    public static String getImgName(String originName) {
        String halfName = originName.substring(originName.lastIndexOf("."));//得到后缀名

        String name = UUID.randomUUID().toString();//生成随机名字
        return name + halfName;
    }

    //定义验证码字符串
    public static String[] strs = {"a","b","c","d","e","f","g","h","j","k","l","m",
            "n","p","q","r","s","t","u","v","w","x","y","z","2","3", "4","5","6","7",
            "8","9"};
    //生成验证码
    public static void getVerifyCode(){

    }

    //生成验证码文件
}
