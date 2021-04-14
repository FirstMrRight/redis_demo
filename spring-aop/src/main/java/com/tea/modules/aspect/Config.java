package com.tea.modules.aspect;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.tea.aspectj
 *
 * @author xiejiemin
 * @create 2021/1/15
 */
@Configuration
public class Config {

    @Bean
    @ConditionalOnExpression("#{beanFactory.containsBeanDefinition('B') || beanFactory.containsBeanDefinition('A')}")
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
