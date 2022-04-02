package com.edward.mt.service;

import com.edward.mt.vo.MtResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {

    //上传菜品头像
    MtResult uploadDishImg(MultipartFile file);
}
