package com.tea.modules.core;

import com.tea.modules.service.MailStrategyService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.jay.company.file.service
 *
 * @author xiejiemin
 * @create 2020/9/28
 */
@Component
@Slf4j
@Getter
public class MailStrategyContext {

    /**
     * 策略
     * KEY为业务编码
     * VALUE为具体实现类
     */
    private final ConcurrentHashMap<String, MailStrategyService> strategy = new ConcurrentHashMap<>();

    /**
     * 注入所有实现 MailStrategyService 接口的类
     * 这里使用的是构造注入的方式将Bean注入进来
     *
     * @param mailServiceList
     */
    public MailStrategyContext(List<MailStrategyService> mailServiceList) {
        log.info("开始注入策略");
        mailServiceList.forEach(mailServiceImpl -> {
            log.info("当前策略类:{}", mailServiceImpl.getClass().getName());
            strategy.put(mailServiceImpl.getServiceProviderName(), mailServiceImpl);
        });
        log.info("注入策略完毕");
    }

    /**
     * 发送邮件
     *
     * @param strategyName 策略名称
     * @param message      发送邮件信息
     */
    public void send(String strategyName, String message) {
        MailStrategyService mailStrategyService = strategy.get(strategyName);
        mailStrategyService.send(message);
    }
}
