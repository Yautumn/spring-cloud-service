package com.yautumn.controller.file;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResultUtil uploadFile(@RequestParam("file") MultipartFile file){
        String data = fileService.fileUpload(file);
        return ResultUtil.success(data);
    }

    /**
     * 获取目录下文件列表
     * @return
     */
    @PostMapping("/file/list")
    public ResultUtil getFileList(){
        List<String> files = fileService.getFileList();
        return ResultUtil.success(files);
    }
}
