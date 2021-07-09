package com.tea.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * com.tea.test
 *
 * @author jaymin
 * @since 2021/7/8
 */
public class Demo {
    public static void main(String[] args) {
        List users = null;
        for (Object user : users) {
            System.out.println(user.hashCode());
        }
    }
}
