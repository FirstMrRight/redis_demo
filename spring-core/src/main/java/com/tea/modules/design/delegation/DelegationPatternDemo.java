package com.tea.modules.design.delegation;

/**
 * @author jaymin<br>
 * 详情见:https://carsonwah.github.io/delegation-pattern.html<br>
 * 名词解释:<br>
 * delegate(v):把...委派给....<br>
 * delegate(n):被委托者<br>
 * delegator(n):委托者<br>
 * delegation(n):一份委托<br>
 * 2020/12/13 21:06
 */
public class DelegationPatternDemo {
    public static void main(String[] args) {
        ITTaskDelegate delegate = new ITTaskDelegate();
        delegate.work("server task");
        delegate.work("hardware task");
    }
}
