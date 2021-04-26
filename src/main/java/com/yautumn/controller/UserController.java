package com.yautumn.controller;

import com.yautumn.common.entity.User;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.parameter.request.local.user.UserIdRequest;
import com.yautumn.parameter.request.local.user.SaveUserRequest;
import com.yautumn.parameter.request.local.user.UpadteUserRequest;
import com.yautumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
        user save method
     */
    @PostMapping("/save")
    public ResultUtil saveUser(@RequestBody SaveUserRequest saveUserRequest){
        int value = userService.saveUser(saveUserRequest);
        return ResultUtil.success();
    }

    /*
        user find by id method
     */
    @GetMapping("/find/id")
    public ResultUtil findUserById(@RequestBody UserIdRequest userIdRequest){
        User user = userService.getUserById(userIdRequest);
        return ResultUtil.success(user);
    }

    /*
        user update by id method
     */
    @PostMapping("/upadte/id")
    public ResultUtil updateUserById(@RequestBody UpadteUserRequest upadteUserRequest){
        int value = userService.updateUserById(upadteUserRequest);
        return ResultUtil.success();
    }

    /*
        user delete by id method
     */
    @DeleteMapping("/del/id")
    public ResultUtil deleteUserById(@RequestBody UserIdRequest userIdRequest){
        int val = userService.deleteUserById(userIdRequest);
        return ResultUtil.success();
    }
}
