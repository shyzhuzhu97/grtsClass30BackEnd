package com.edward.mt.service.impl;

import com.edward.mt.constant.MtConstant;
import com.edward.mt.exception.MtException;
import com.edward.mt.service.ImgService;
import com.edward.mt.utils.UploadUtils;
import com.edward.mt.vo.MtResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImgServiceImpl implements ImgService {
    @Override
    public MtResult uploadDishImg(MultipartFile file) {
        File dateFolder = UploadUtils.getDishImgFolderRoot();
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

        return MtResult.ok().data("imgPath", MtConstant.HOST + "/" + UploadUtils.getDishImgFolder() + "/" + imgName);
    }
}

