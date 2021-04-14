package com.tea.modules.service;

/**
 * com.jay.company.file.service
 *
 * @author xiejiemin
 * @create 2020/9/28
 */
public interface MailStrategyService {

    /**
     * 服务提供商名称
     *
     * @return
     */
    public String getServiceProviderName();

    /**
     * 发送邮件
     *
     * @param message
     */
    public void send(String message);

}
