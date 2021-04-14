package com.tea.modules.design.singleton;

/**
 * 懒汉模式的单例<br>
 * 线程安全-使用双重检查锁<br>
 *
 * @author 95152
 */
public class LazySingletonDemo {
    /**
     * 使用volatile让变量线程可见，防止指令重排序
     */
    private volatile static LazySingletonDemo instance = null;

    /**
     * 反射是可以破坏private的，所以这种单例模式并不是绝对的安全
     */
    private LazySingletonDemo() {
        System.out.println("我是一个单例");
    }

    public static LazySingletonDemo getInstance() {
        // 第一次检测
        if (instance == null) {
            // 同步锁，类锁
            synchronized (LazySingletonDemo.class) {
                // 如果另一个线程已经创建了这个类了，那么就不需要创建了
                if (instance == null) {
                    // memory = allocate() 1. 分配对象内存空间
                    // instance(memory) 2. 初始化对象
                    // instance = memory  3. 设置instance指向刚分配的内存地址，此时instance != null
                    // 2与3并无依赖关系，会导致指令重排序，所以需要加上vola tile修饰符,否则会导致下一个线程进来直接返回一个并没有初始化的内存地址
                    instance = new LazySingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}