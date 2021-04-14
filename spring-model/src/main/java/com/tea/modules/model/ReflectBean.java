package com.tea.modules.model;

/**
 * @author jaymin<br>
 * 反射基础类<br>
 * 2020/11/8 1:12
 */
public class ReflectBean {
    /**
     * field-名称
     */
    public String name;
    /**
     * 受保护的field-index
     */
    protected Integer index;
    /**
     * 默认的field-type
     */
    char type;
    /**
     * 私有的field-targetInfo
     */
    private String targetInfo;
    /**
     * 静态的成员变量
     */
    private static String staticField;

    @Override
    public String toString() {
        return "ReflectBean{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    /**
     * 默认的构造器
     *
     * @param str
     */
    ReflectBean(String str) {
        System.out.println("default constructor of ReflectBean");
    }

    /**
     * 无参的构造器
     */
    public ReflectBean() {
        System.out.println("using no args constructor of ReflectBean");
    }

    /**
     * 有一个参数的构造器
     *
     * @param name
     */
    public ReflectBean(char name) {
        System.out.println("using a constructor of ReflectBean which has an arg");
    }


    /**
     * 有二个参数的构造器
     *
     * @param name
     */
    public ReflectBean(char name, int index) {
        System.out.println("using a constructor of ReflectBean which has two args : name:[" + name + "]index:[" + index + "]");
    }

    /**
     * 受保护的构造函数
     *
     * @param n
     */
    protected ReflectBean(boolean n) {
        System.out.println("using a constructor of ReflectBean which is protected,boolean:" + n);
    }

    /**
     * 私有的构造函数
     *
     * @param index
     */
    private ReflectBean(int index) {
        System.out.println("using a constructor of ReflectBean which is private,index:" + index);
    }

    /**
     * 公有的成员方法
     *
     * @param message
     */
    public void display(String message) {
        System.out.println("Using a public method: display,print message:" + message);
    }

    /**
     * 受保护的无参成员方法
     */
    protected void show() {
        System.out.println("Using a protected method: show");
    }

    /**
     * 默认的无参成员方法
     */
    void defaultShow() {
        System.out.println("Using a default method which has no args");
    }

    /**
     * 私有的成员方法
     * @param index
     * @return
     */
    private String getMessage(int index) {
        return "Using a private method,your parameter is index:" + index;
    }

    public String getStaticField() {
        return staticField;
    }
}
