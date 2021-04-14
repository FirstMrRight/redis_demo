package com.tea.modules.java8.generic;


import com.tea.modules.model.RestResult;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;


/**
 * @author jaymin<br>
 * 泛型类<br>
 * 2020/11/6 18:18
 */
@Slf4j
@SuppressWarnings("all")
public class GenericDemo {

    /**
     * 输入多个参数，返回参数中的中位数
     *
     * @param param 可变参数
     * @param <T>
     * @return
     */
    private static <T> T genericMethod(T... param) {
        return param[param.length / 2];
    }

    /**
     * 泛型擦除
     */
    private static void genericErase() {
        RestResult<String> stringRestResult = new RestResult<>();
        RestResult<Integer> integerRestResult = new RestResult<>();
        System.out.println("stringRestResult实例在运行时的信息:" + stringRestResult.getClass());
        System.out.println("integerRestResult实例在运行时的信息:" + integerRestResult.getClass());
    }

    /**
     * 给定一个数组，返回数组中的最小值
     *
     * @param array
     * @param <T>   传入的T对象必须实现Comparable接口
     * @return
     */
    private static <T extends Comparable> T min(T[] array) {
        if (array == null && array.length == 0) {
            return null;
        }
        T smallest = array[0];
        for (T element : array) {
            if (smallest.compareTo(element) > 0) {
                smallest = element;
            }
        }
        return smallest;
    }

    /**
     * 泛型方法，给定一个Supplier函数式接口，返回具体的类型
     * @param constr
     * @param <T>
     * @return
     */
    private static <T> T getInstance(Supplier<T> constr) {
        return constr.get();
    }

    /**
     * 传统方法解决泛型实例化，反射
     * @param clazz clazz 注意,Class类本身是泛型，例如String.class是Class<String>的实例
     * @param <T>
     * @return
     */
    private static <T> T getInstanceByClass(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // 演示使用，非正确用法
            throw new RuntimeException("An exception occurred when using newInstance");
        }
    }

    /**
     * 展示类型继承规则
     * @param restResult
     */
    private static void printResultData(RestResult<Integer> restResult) {
        Integer data = restResult.getData();
        System.out.println("The RestResult is :" + data);
    }


    /**
     * 使用无限定通配符来传参，但是会有类型转换的风险
     * @param restResult
     */
    private static void printResultDataByWildcard(RestResult<?> restResult) {
        Integer data = ((Integer) restResult.getData());
        System.out.println("The RestResult is :" + data);
    }


    /**
     * 限制下边界为Integer
     *
     * @param restResult
     */
    private static void printResult(RestResult<? super Integer> restResult) {
        Integer data = ((Integer) restResult.getData());
        System.out.println("The RestResult is :" + data);
    }


    public static void main(String[] args) {
        Integer integer = genericMethod(1, 2, 3);
        System.out.println(integer);
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println(min(array));
        String instance = getInstance(String::new);
        String instanceByClass = getInstanceByClass(String.class);
        RestResult<Number> integerRestResult = new RestResult<>();
        integerRestResult.setData(Integer.valueOf("10086"));
        printResultDataByWildcard(integerRestResult);
/*
        RestResult<String> stringRestResult = new RestResult<>();
        stringRestResult.setData("10086");
        printResultDataByWildcard(stringRestResult);*/

        RestResult<String> testNullRestResult = new RestResult<>();
        testNullRestResult.setData(null);
        boolean b = testNullRestResult.resultDataIsNull(testNullRestResult);
        System.out.println(b);
    }
}
