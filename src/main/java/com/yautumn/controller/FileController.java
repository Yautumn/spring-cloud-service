package com.yautumn.controller;

import com.yautumn.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    public ResultUtil uploadFile(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return ResultUtil.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/yautumn/fileupload/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return ResultUtil.success("上传成功");
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return ResultUtil.error("上传失败！");
    }

    @PostMapping("/file/list")
    public ResultUtil getFileList(){
        String basePath = "/Users/yautumn/fileupload/";
        String[] fileArr=new File(basePath).list();
        List<String> files = new ArrayList<>();
        for (int i = 0; i < fileArr.length; i++) {
            files.add(basePath + fileArr[i].toString());
        }
        return ResultUtil.success(files);
    }
}
