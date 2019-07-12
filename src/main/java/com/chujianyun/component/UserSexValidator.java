package com.chujianyun.component;

import com.chujianyun.entity.param.UserParam;
import com.chujianyun.exception.BusinessException;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class UserSexValidator extends Validator<UserParam> {

    @Override
    void validate(UserParam param) {
        System.out.println("验证性别");
        if (param == null) {
            throw new BusinessException("");
        }
        // 模拟服务，根据userId查询性别
        boolean isFemale = RandomUtils.nextBoolean();
        if (!isFemale) {
            throw new BusinessException("仅限女性玩家哦！");
        }
    }
}
