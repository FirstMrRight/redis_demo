package com.tea.modules.java8.stream;

import com.tea.modules.model.po.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * com.xjm.java8.stream<br>
 * 探索闭包<br>
 * @author xiejiemin
 * @create 2021/1/7
 */
public class ClosureDemo {
    private static class MyClosure {
        public int value;
        public MyClosure(int initValue) { this.value = initValue; }
    }
/*    public static Map<String, Supplier> createCounter(int initValue) {
        MyClosure closure = new MyClosure(initValue);
        Map<String, Supplier> counter = new HashMap<>();
        counter.put("val", () -> closure.value);
        counter.put("inc", () -> closure.value++);
        return counter;
    }*/


    public static void main(String[] args) {

/*        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());

        Closure2 c2 = new Closure2();
        IntSupplier intSupplier1 = c2.makeFun(0);
        IntSupplier intSupplier2 = c2.makeFun(0);
        IntSupplier intSupplier3 = c2.makeFun(0);
        System.out.println(intSupplier1.getAsInt());
        System.out.println(intSupplier2.getAsInt());
        System.out.println(intSupplier3.getAsInt());


        Closure8 c7 = new Closure8();
        List<Integer>
                l1 = c7.makeFun().get(),
                l2 = c7.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);*/

    }

    public static class Closure10 {
        Student student = new Student();
        Supplier supplier = () -> {
            student.setAge(10);
            return student;
        };
    }

    public static class Closure1 {
        int i;
        IntSupplier makeFun(int x) {
            return () -> x + i++;
        }
    }

    public static class Closure2 {
        IntSupplier makeFun(int x) {
            Integer i = 0;
            return () -> x + i;
        }
    }

    public static class Closure8 {
        Supplier<List<Integer>> makeFun() {
            final List<Integer> ai = new ArrayList<>();
            ai.add(1);
            return () -> ai;
        }
    }

/*    public class Closure9 {
        Supplier<List<Integer>> makeFun() {
            List<Integer> ai = new ArrayList<>();
            ai = new ArrayList<>(); // Reassignment
            return () -> ai;
        }
    }*/
}
