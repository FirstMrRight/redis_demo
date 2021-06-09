package com.tea.modules.java8.extend;

/**
 * com.tea.modules.java8.extend <br>
 * 可变参数列表
 *
 * @author jaymin
 * @since 2021/6/9
 */
class A {
}

public class VarArgs {

    /**
     * 打印对象数组的内容
     * @param args 数组
     */
    static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    /**
     * 打印可变参数列表
     * @param args 指定参数时，编译器实际上会为你填充数组
     */
    static void printObjectArgs(Object... args) {
        for (Object obj: args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        printArrayTest();
//        printObjectArgsTest();
        varargType ();
    }

    private static void printArrayTest() {
        printArray(new Object[]{47, (float) 3.14, 11.11});
        printArray(new Object[]{"one", "two", "three"});
        // 打印对象的引用地址
        printArray(new Object[]{new A(), new A(), new A()});
    }

    private static void printObjectArgsTest(){
        // Can take individual elements:
        printObjectArgs(47, (float) 3.14, 11.11);
        printObjectArgs(47, 3.14F, 11.11);
        printObjectArgs("one", "two", "three");
        printObjectArgs(new A(), new A(), new A());

        // Or an array:
        printObjectArgs((Object[]) new Integer[] {1, 2, 3, 4});
        // Empty list is OK
        printObjectArgs();
    }

    /**
     * 装箱类型作为可变参数,传入的参数会自动装箱
     * @param args
     */
    static void printfCharArgs(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    /**
     * 基础类型作为可变参数
     * @param args
     */
    static void printBaseTypeArgs(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    /**
     * 可变参数类型:   <br>
     * 测试是否可以打印基础类型的class信息
     */
    private static void varargType () {
        printfCharArgs('a');
        printfCharArgs();
        printBaseTypeArgs(1);
        printBaseTypeArgs();
        System.out.println("int[]: "+ new int[0].getClass());
    }
}
