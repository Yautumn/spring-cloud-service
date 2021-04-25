package com.yautumn.service;

import com.yautumn.common.entity.User;
import com.yautumn.parameter.request.local.user.UserIdRequest;
import com.yautumn.parameter.request.local.user.SaveUserRequest;
import com.yautumn.parameter.request.local.user.UpadteUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int saveUser(SaveUserRequest saveUserRequest);

    User getUserById(UserIdRequest userIdRequest);

    int updateUserById(UpadteUserRequest upadteUserRequest);

    int deleteUserById(UserIdRequest userIdRequest);
}
