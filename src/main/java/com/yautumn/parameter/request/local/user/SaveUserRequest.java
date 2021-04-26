package com.yautumn.parameter.request.local.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * save user request parameter
 */
@Getter
@Setter
public class SaveUserRequest {
    private String userName;

    private String userPassword;

    private String userSex;

}
