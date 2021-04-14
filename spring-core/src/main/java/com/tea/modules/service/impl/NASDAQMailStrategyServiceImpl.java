package com.tea.modules.service.impl;

import com.tea.modules.service.MailStrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * com.jay.company.file.service
 *
 * @author xiejiemin
 * @create 2020/9/28
 */
@Service
@Slf4j
public class NASDAQMailStrategyServiceImpl implements MailStrategyService, BeanNameAware {

    @Override
    public String getServiceProviderName() {
        return "ntes";
    }

    @Override
    public void send(String message) {
        log.info("现在向网易邮箱发送邮件:{}",message);
    }

    @Override
    public void setBeanName(String s) {
        log.info("bean Name:{},hashcode:{}",s,this.hashCode());
    }
}
