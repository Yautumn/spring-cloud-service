package com.yautumn.dao.transforeffect;

import com.yautumn.common.entity.TransforEffect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransforEffectMapper {
    int insert(TransforEffect record);

    int insertForeach(List<TransforEffect> list);

    int insertSelective(TransforEffect record);
}