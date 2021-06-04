package com.tea.modules.java8.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * com.tea.modules.java8.generic <br>
 * 不要使用原始类型
 * @author jaymin
 * @since 2021/6/4
 */
@SuppressWarnings("all")
public class DoNotUseRawType {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("2");
    }
}
