package com.yautumn.service.file.impl;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Value("${fileUploadPath}")
    private String fileUploadPath;

    @Override
    public String fileUpload(MultipartFile file) {

        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        //文件上传路径
        File dest = new File(fileUploadPath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @Override
    public List<String> getFileList() {
        String[] fileArr=new File(fileUploadPath).list();
        List<String> files = new ArrayList<>();
        for (int i = 0; i < fileArr.length; i++) {
            files.add(fileUploadPath + fileArr[i].toString());
        }
        return files;
    }
}
