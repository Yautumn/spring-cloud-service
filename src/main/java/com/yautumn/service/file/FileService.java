package com.yautumn.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    String fileUpload(MultipartFile file);

    List<String> getFileList();

}
