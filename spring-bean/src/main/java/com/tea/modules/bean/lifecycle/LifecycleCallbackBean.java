package com.tea.modules.bean.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author jaymin
 * 2021/2/7 22:26
 */
@Slf4j
public class LifecycleCallbackBean implements InitializingBean {

    @PostConstruct
    public void postConstruct(){
        log.info("postConstruct....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet....");
    }

    public void init(){
        log.info("init....");
    }
}
