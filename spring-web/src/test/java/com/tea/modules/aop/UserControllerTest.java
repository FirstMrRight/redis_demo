package com.tea.modules.aop;

import com.tea.modules.aop.controller.UserController;
import com.tea.modules.introduction.CustomizeProcessor;
import com.tea.modules.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2021/2/12 21:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void login() {
        userController.login(User.builder().userName("超人").password("123456").build());
    }

    @Test
    public void introduction(){
        ((CustomizeProcessor) userController).enhance();
    }

}
