package com.chujianyun.component;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class ValidatorChain implements ApplicationContextAware {

    private Map<Class, List<Validator>> validatorMap = new HashMap<>();

    /**
     * 参数校验
     */
    public <P> void checkParam(P param) {
        checkParam(param, validator -> true);
    }

    /**
     * 符合某种条件才参数校验
     */
    public <P> void checkParam(P param, Predicate<Validator> predicate) {
        List<Validator> validators = getValidators(param.getClass());
        if (CollectionUtils.isNotEmpty(validators)) {
            validators.stream()
                    .filter(predicate)
                    .forEach(validator -> validator.validate(param));
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Validator> beansOfType = applicationContext.getBeansOfType(Validator.class);
        this.validatorMap = beansOfType.values().stream().collect(Collectors.groupingBy(validator -> getParamType(validator.getClass())));
    }

    /**
     * 查找相关的所有校验器
     */
    private List<Validator> getValidators(Class clazz) {
        return validatorMap.get(clazz);
    }

    /**
     * 解析泛型待校验参数类型
     */
    private Class getParamType(Class clazz) {
        ResolvableType resolvableType = ResolvableType.forClass(clazz);
        return resolvableType.getSuperType().getGeneric(0).resolve();
    }
}
