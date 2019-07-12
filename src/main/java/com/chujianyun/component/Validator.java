package com.chujianyun.component;

import lombok.Data;

import java.util.Set;

@Data
public abstract class Validator<P> {
    /**
     * 校验分组，枚举
     */
    private Set<Enum> groups;

    /**
     * 验证参数
     */
    abstract void validate(P param);


}
