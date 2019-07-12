package com.chujianyun.service;

import com.chujianyun.entity.dto.UserDTO;
import com.chujianyun.entity.param.UserParam;

public interface UserService {

    UserDTO checkUser(UserParam userParam);

    UserDTO checkUserSome(UserParam userParam);
}
