package com.tea.modules.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * com.tea.conditional
 *
 * @author xiejiemin
 * @create 2021/1/14
 */
public class LogOnBeanConditional implements Condition {

    public static final String BEAN_NAME = "A";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Arrays.stream(context.getRegistry().getBeanDefinitionNames()).forEach(System.out::println);
        if (context.getBeanFactory().containsBean(BEAN_NAME)) {
            return true;
        }
        return false;
    }
}
