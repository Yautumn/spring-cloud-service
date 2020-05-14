package com.yautumn.controller;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.request.user.SaveUserRequest;
import com.yautumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
