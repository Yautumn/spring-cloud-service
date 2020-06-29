package com.yautumn.dao.userdid;

import com.yautumn.common.entity.UserDid;

import java.util.List;

public interface UserDidMapper {
    int deleteByPrimaryKey(String fDid);

    int insert(UserDid record);

    int insertForeach(List<UserDid> record);

    int insertSelective(UserDid record);
}