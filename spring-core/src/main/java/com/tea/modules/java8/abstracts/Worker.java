package com.tea.modules.java8.abstracts;

/**
 * com.tea.modules.java8.abstracts <br>
 * 员工类 <br>
 * 抽象类是子类的通用特性，包含了属性和行为；接口是定义行为，并不关心谁去实现。<br>
 * 抽象类本身是对类本身的抽象，表达的是is-a的关系；接口是对行为的抽象，表达的是like a的关系<br>
 * 相同点: <br>
 * 接口方法和抽象类中的抽象方法不能有方法体，并且子类必须实现。(java8加入了default); <br>
 * 都可以被继承，但是不可以实例化 <br>
 * 区别: <br>
 * 使用时的语法不同，抽象类使用extends，接口则用implements <br>
 * 接口中只能定义常量，所以，接口不能表达对象的状态，但是抽象类可以 <br>
 * 接口方法必须是public类型的，但是抽象类则没有 <br>
 * 类可以同时实现多个接口，但是只能继承一个类 <br>
 * @author jaymin
 * @since 2021/6/3
 */
public class Worker extends BaseWorker implements IBaseWorking, IExtraWorking {
    @Override
    protected void clockIn() {

    }

    @Override
    protected void clockOut() {

    }

    @Override
    public void baseCoding() {

    }

    @Override
    public void baseTesting() {

    }

    @Override
    public void extraWorking() {

    }

    @Override
    public void extraTesting() {

    }
}
