package com.yautumn.controller.communication;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.communication.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

    @Autowired
    private CommunicationService communicationService;

    /**
     * 解析工单excel
     * @param fileName
     * @return
     */
    @PostMapping("/analysis")
    public ResultUtil analysisOrderExcel(String fileName){
        communicationService.readExcel(fileName);
        return ResultUtil.success();
    }
}
