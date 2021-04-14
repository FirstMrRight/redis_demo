package com.tea.modules.bean.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * com.tea.modules
 *
 * @author xiejiemin
 * @create 2021/1/14
 */
@Component
@Slf4j
public class LogBeanNameBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.debug("******************************Loading Bean***********************************************");
        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())
                .forEach(log::debug);
        log.debug("**********************************END****************************************************");
    }
}
