package com.tea.modules.service.impl;

import com.tea.modules.service.MailStrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * com.jay.company.file.service
 *
 * @author xiejiemin
 * @create 2020/9/28
 */
@Service
@Slf4j
public class QQMailStrategyServiceImpl implements MailStrategyService {

    @Override
    public String getServiceProviderName() {
        return "qq";
    }

    @Override
    public void send(String message) {
       log.info("向QQ邮箱发送邮件:{}",message);
    }
}
