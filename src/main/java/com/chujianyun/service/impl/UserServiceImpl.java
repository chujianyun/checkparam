package com.chujianyun.service.impl;

import com.chujianyun.component.ValidatorChain;
import com.chujianyun.entity.dto.UserDTO;
import com.chujianyun.entity.enums.UserValidateGroupEnum;
import com.chujianyun.entity.param.UserParam;
import com.chujianyun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ValidatorChain validatorChain;

    @Override
    public UserDTO checkUser(UserParam userParam) {

        // 参数校验
        validatorChain.checkParam(userParam);
        // 业务逻辑
        return new UserDTO("测试");
    }

    @Override
    public UserDTO checkUserSome(UserParam userParam) {
        // 参数校验(只校验类型为Some的)
        validatorChain.checkParam(userParam, param -> param.getGroups().contains(UserValidateGroupEnum.SOME));

        // 业务逻辑
        return new UserDTO("测试");
    }
}
