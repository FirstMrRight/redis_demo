package com.tea.modules.service;

import com.tea.modules.model.User;

/**
 * @author jaymin
 * 2021/2/12 21:06
 */
public interface UserService {
    /**
     * 用户登陆接口
     * @param user
     */
    User login(User user);
}
