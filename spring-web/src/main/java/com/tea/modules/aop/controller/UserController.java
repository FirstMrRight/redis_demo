package com.tea.modules.aop.controller;

import com.tea.modules.model.po.User;
import com.tea.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jaymin
 * 2021/2/12 21:26
 */
@RestController("web")
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }
}
