package com.tea.modules.design.chain.middleware;

/**
 * Base middleware class.
 * @author Liu-PC
 * @Description 基础验证接口
 */
public abstract class Middleware {
    private Middleware next;

    /**
     * Builds chains of middleware objects.
     *
     * @param next
     * @return
     */
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     *
     * @param email
     * @param password
     * @return
     */
    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.checkNext(email, password);
    }

}
