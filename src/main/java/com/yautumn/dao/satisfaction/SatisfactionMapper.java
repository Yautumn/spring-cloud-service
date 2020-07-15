package com.yautumn.dao.satisfaction;

import com.yautumn.common.entity.Satisfaction;

import java.util.List;

public interface SatisfactionMapper {
    int insert(Satisfaction record);

    int insertForeach(List<Satisfaction> satisfactions);
}