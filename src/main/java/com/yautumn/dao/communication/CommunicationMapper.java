package com.yautumn.dao.communication;

import com.yautumn.common.entity.Communication;

import java.util.List;

public interface CommunicationMapper {
    int insert(Communication record);

    int insertForeach(List<Communication> record);

    int insertSelective(Communication record);
}