package com.tea.modules.bean.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.tea.modules.bean.di
 *
 * @author xiejiemin
 * @create 2021/1/14
 */
@RestController
public class UserController {

    @Autowired
    @Qualifier("normalUserService")
    private UserService userService;

    /**
     * 用户登陆入口
     */
    @PostMapping("/login")
    public void login() {
        userService.login();
    }
}
