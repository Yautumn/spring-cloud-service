package com.yautumn.dao.robot;

import com.yautumn.common.entity.Order;
import com.yautumn.common.entity.Robot;

import java.util.List;

public interface RobotMapper {
    int insert(Robot record);

    int insertForeach(List<Robot> record);

    int insertSelective(Robot record);
}