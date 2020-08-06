package com.yautumn.service;

import com.yautumn.common.entity.User;
import com.yautumn.parameter.request.local.user.FindUserByIdRequest;
import com.yautumn.parameter.request.local.user.SaveUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int saveUser(SaveUserRequest saveUserRequest);

    User getUserById(FindUserByIdRequest findUserByIdRequest);
}
