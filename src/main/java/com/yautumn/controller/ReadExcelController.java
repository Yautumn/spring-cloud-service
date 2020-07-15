package com.yautumn.controller;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.loss.LossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excel")
public class ReadExcelController {
    @Autowired
    private LossService lossService;

    @PostMapping("/save")
    public ResultUtil saveLoss(String fileName){
        lossService.readExcel(fileName);
        return ResultUtil.success();
    }
}
