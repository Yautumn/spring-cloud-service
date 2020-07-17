package com.yautumn.controller;

import com.yautumn.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${filePath}")
    private String filePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResultUtil uploadFile(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return ResultUtil.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        //文件上传路径
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return ResultUtil.success("上传成功");
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return ResultUtil.error("上传失败！");
    }

    /**
     * 获取目录下文件列表
     * @return
     */
    @PostMapping("/file/list")
    public ResultUtil getFileList(){
        String[] fileArr=new File(filePath).list();
        List<String> files = new ArrayList<>();
        for (int i = 0; i < fileArr.length; i++) {
            files.add(filePath + fileArr[i].toString());
        }
        return ResultUtil.success(files);
    }
}
