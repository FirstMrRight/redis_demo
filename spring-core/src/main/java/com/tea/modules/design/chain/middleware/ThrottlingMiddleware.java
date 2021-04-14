package com.tea.modules.design.chain.middleware;

/**
 * @author Liutx
 * @date 2021/1/17 16:30
 * @Description 请求数量（次数）限制
 * ConcreteHandler. Checks whether there are too many failed login requests.
 */

public class ThrottlingMiddleware extends Middleware {
    public static final long A_MINUTE = 60_000;

    /**
     * 请求间隔
     */
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + A_MINUTE) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().interrupt();
        }
        return checkNext(email, password);
    }
}
