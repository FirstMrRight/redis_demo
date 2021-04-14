package com.tea.modules.java8.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jaymin
 * 2021/2/1 22:05
 */
public class FinalOfString {
    /**
     * 集合对象其实是在栈中持有引用.真正的数据存储在堆中.所以put操作是可行的.因为引用没有发生改变
     */
    private static final Map<String, Object> finalMap = new HashMap();

    private static final String FINAL_STRING = "finalString";
    public static void main(String[] args) {
        finalMap.put("a", 1);
        // 此处会报错，为什么?因为String已经指向了常量池中的"finalString",String本身也是不可变的，所以重新赋值相当于更换引用.
        // FINAL_STRING = "other";
    }
}
