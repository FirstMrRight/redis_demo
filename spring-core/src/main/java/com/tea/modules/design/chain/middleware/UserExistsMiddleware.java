package com.tea.modules.design.chain.middleware;

import com.tea.modules.design.chain.middleware.server.Server;

/**
 * @author Liutx
 * @date 2021/1/17 16:51
 * @Description 检查用户登录信息
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
public class UserExistsMiddleware extends Middleware {

    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }


    /**
     *
     * @param email
     * @param password
     * @return 返回true/false  通过条件来控制责任链是否向下进行
     */
    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }

        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }

        return checkNext(email, password);
    }
}
