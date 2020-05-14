package com.yautumn.service.impl;

import com.yautumn.common.entity.User;
import com.yautumn.dao.user.UserMapper;
import com.yautumn.request.user.SaveUserRequest;
import com.yautumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(SaveUserRequest saveUserRequest) {
        User user = new User();
        user.setUserName(saveUserRequest.getUserName());
        user.setUserPassword(saveUserRequest.getUserPassword());
        user.setUserSex(saveUserRequest.getUserSex());
        user.setUserBirthday(new Date());
        int val = userMapper.insert(user);
        return val;
    }
}
