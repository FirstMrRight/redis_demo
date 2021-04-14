package com.tea.modules.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin
 * 2021/2/7 22:29
 */
@Configuration
public class BeanConfig {

    @Bean(initMethod = "init")
    public LifecycleCallbackBean lifecycleCallbackBean(){
        return new LifecycleCallbackBean();
    }
}
