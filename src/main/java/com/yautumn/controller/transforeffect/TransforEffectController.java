package com.yautumn.controller.transforeffect;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.transforeffect.TransforEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transforeffect")
public class TransforEffectController {

    @Autowired
    private TransforEffectService transforEffectService;

    @PostMapping("/analysis")
    public ResultUtil analysisOrderExcel(String fileName){
        transforEffectService.readExcel(fileName);
        return ResultUtil.success();
    }
}
