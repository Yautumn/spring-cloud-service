package com.yautumn.controller.excel;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.mapper.resultmap.active.CallDetailMap;
import com.yautumn.parameter.request.local.CallDetailRequest;
import com.yautumn.service.excel.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 导出主动进线拨打明细
     * @param param
     * @return
     */
    @PostMapping("/calldetail")
    public ResultUtil exportRecallDetail(@RequestBody CallDetailRequest param){
        List<CallDetailMap> callDetail = excelService.getCallDetail(param);
        return ResultUtil.success();
    }

}
