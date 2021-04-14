package com.tea.modules.service.impl;

import com.tea.modules.annotation.Log;
import com.tea.modules.enums.ExceptionEnums;
import com.tea.modules.exception.RestfulException;
import com.tea.modules.model.User;
import com.tea.modules.service.UserService;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jaymin
 * 2021/2/12 21:06
 */
@Service("webUserServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        log.info("当前登陆用户信息:{}", JacksonUtils.toJsonString(user));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.info("线程睡眠异常:{}", e);
            throw new RestfulException(e);
        }
        throw new RestfulException(ExceptionEnums.AUTH_ERROR);
    }

    @Log
    public void log(){
        log.info("看看我是否被环绕了");
    }
}
