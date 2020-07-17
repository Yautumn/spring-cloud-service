package com.yautumn.controller;

import com.yautumn.common.entity.User;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.request.user.FindUserByIdRequest;
import com.yautumn.request.user.SaveUserRequest;
import com.yautumn.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResultUtil saveUser(@RequestBody SaveUserRequest saveUserRequest){
        int value = userService.saveUser(saveUserRequest);
        return ResultUtil.success();
    }

    @PostMapping("/find/id")
    public ResultUtil findUserById(@RequestBody FindUserByIdRequest findUserByIdRequest){
        User user = userService.getUserById(findUserByIdRequest);
        return ResultUtil.success(user);
    }
}
