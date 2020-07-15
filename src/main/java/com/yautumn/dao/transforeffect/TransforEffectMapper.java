package com.yautumn.dao.transforeffect;

import com.yautumn.common.entity.TransforEffect;

import java.util.List;

public interface TransforEffectMapper {
    int insert(TransforEffect record);

    int insertForeach(List<TransforEffect> record);

    int insertSelective(TransforEffect record);
}