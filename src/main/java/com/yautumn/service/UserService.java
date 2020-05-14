package com.yautumn.service;

import com.yautumn.request.user.SaveUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int saveUser(SaveUserRequest saveUserRequest);

}
