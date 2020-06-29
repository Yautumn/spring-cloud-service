package com.yautumn.dao.order;

import com.yautumn.common.entity.Order;

import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    int insertForeach(List<Order> record);

    int insertSelective(Order record);
}