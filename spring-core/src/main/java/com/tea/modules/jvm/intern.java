package com.tea.modules.jvm;

public class intern {
    public static void main(String[] args) {
        //直接new会在堆与常量池中一起创建出1
        String s = new String("1");
        //1已经有了，无法把引用放进去，也就是现在堆中的1和常量池的1是不一样的
        s.intern();
        //指向常量池的1
        String s1 = "1";
        System.out.println(s==s1);

        //这个aa是通过StringBuilder的append拼接出来的，并没有在常量池中创建
        String s3 = new String("a")+new String("a");
        //发现常量池中无aa，添加aa的引用进入常量池
        s3.intern();
        //将aa的引用赋予给aa
        String s4 = "aa";
        System.out.println(s3==s4);

    }
}
