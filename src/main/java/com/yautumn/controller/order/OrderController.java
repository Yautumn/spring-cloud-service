package com.yautumn.controller.order;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/analysis")
    public ResultUtil analysisOrderExcel(String fileName){
        orderService.readExcel(fileName);
        return ResultUtil.success();
    }
}
