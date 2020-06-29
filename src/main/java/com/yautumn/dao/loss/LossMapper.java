package com.yautumn.dao.loss;

import com.yautumn.common.entity.Loss;

import java.util.List;

public interface LossMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loss record);

    int insertForeach(List<Loss> losses);

    int insertSelective(Loss record);

    Loss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loss record);

    int updateByPrimaryKey(Loss record);
}