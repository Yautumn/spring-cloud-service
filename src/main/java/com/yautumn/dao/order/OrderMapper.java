package com.yautumn.dao.order;

import com.yautumn.common.entity.Order;
import com.yautumn.mapper.resultmap.active.CallDetailMap;
import com.yautumn.mapper.resultmap.loss.FallCallBackDetailMap;
import com.yautumn.parameter.request.local.CallDetailRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderMapper {

    int insert(Order record);

    int insertForeach(List<Order> record);

    List<CallDetailMap> callDetail(CallDetailRequest param);

    List<FallCallBackDetailMap> fallCallBackDetail();

    int insertSelective(Order record);
}