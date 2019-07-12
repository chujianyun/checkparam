package com.chujianyun.component;

import lombok.Data;

@Data
public abstract class Validator<P> {
    /**
     * 校验分组，枚举
     */
    private Enum group;

    /**
     * 验证参数
     */
    abstract void validate(P param);
}
