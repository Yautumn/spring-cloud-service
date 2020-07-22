package com.yautumn.controller.loss;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.loss.LossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/loss")
public class LossController {


    @Autowired
    private LossService lossService;

    @PostMapping("/analysis")
    public ResultUtil analysisLossExcel(String fileName){
        lossService.readExcel(fileName);
        return ResultUtil.success();
    }

    @PostMapping("/write")
    public ResultUtil writeLossExcel(){
        File data = lossService.writeExcel();
        return ResultUtil.success(data);
    }
}
