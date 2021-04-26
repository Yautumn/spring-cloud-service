package com.yautumn.parameter.request.local.user;

import lombok.Getter;
import lombok.Setter;

/**
 * update user request parameter
 */
@Getter
@Setter
public class UpadteUserRequest {

    private Integer id;

    private String userName;

    private String userPassword;

    private String userSex;
}
