package com.yautumn.service.impl;

import com.alibaba.fastjson.JSON;
import com.yautumn.common.entity.User;
import com.yautumn.common.utils.redis.JedisUtils;
import com.yautumn.dao.user.UserMapper;
import com.yautumn.parameter.request.local.user.UserIdRequest;
import com.yautumn.parameter.request.local.user.SaveUserRequest;
import com.yautumn.parameter.request.local.user.UpadteUserRequest;
import com.yautumn.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisUtils jedisUtils;

    @Value("${redisprefix}")
    private String keyPre;

    @Override
    public int saveUser(SaveUserRequest saveUserRequest) {
        User user = new User();
        user.setUserName(saveUserRequest.getUserName());
        user.setUserPassword(saveUserRequest.getUserPassword());
        user.setUserSex(saveUserRequest.getUserSex());
        user.setUserBirthday(new Date());
        return userMapper.insert(user);

    }
    public User getUserById(UserIdRequest userIdRequest){
        User user;
        boolean flag = jedisUtils.hasKey(this.getRedisKey(userIdRequest.getId()));
        if (flag){
            String userStr = (String) jedisUtils.getObject(this.getRedisKey(userIdRequest.getId()));
            user = JSON.parseObject(userStr,User.class);
        }else {
            user = userMapper.selectByPrimaryKey(userIdRequest.getId());
            jedisUtils.setObject(this.getRedisKey(userIdRequest.getId()), JSON.toJSONString(user));
        }
        return user;
    }

    public int updateUserById(UpadteUserRequest upadteUserRequest){
        UserIdRequest userIdRequest = new UserIdRequest();
        userIdRequest.setId(upadteUserRequest.getId());
        User user = this.getUserById(userIdRequest);
        int val = userMapper.updateByPrimaryKey(user);
        User redisUser = new User();
        BeanUtils.copyProperties(upadteUserRequest,redisUser);
        jedisUtils.setObject(this.getRedisKey(userIdRequest.getId()),redisUser);
        return val;
    }

    public int deleteUserById(UserIdRequest userIdRequest){
        int val = userMapper.deleteByPrimaryKey(userIdRequest.getId());
        boolean flag = jedisUtils.hasKey(this.getRedisKey(userIdRequest.getId()));
        if (flag){
            jedisUtils.delete(this.getRedisKey(userIdRequest.getId()));
        }
        return val;
    }

    private String getRedisKey(Integer id){
        return jedisUtils.getKeyStr(keyPre,id);
    }
}
