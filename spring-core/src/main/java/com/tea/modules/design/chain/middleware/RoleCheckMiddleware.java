package com.tea.modules.design.chain.middleware;

/**
 * @author Liutx
 * @date 2021/1/17 17:20
 * @Description 检查用户角色
 * ConcreteHandler. Checks a user's role.
 */
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
