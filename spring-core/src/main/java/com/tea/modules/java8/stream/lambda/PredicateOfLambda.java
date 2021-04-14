package com.tea.modules.java8.stream.lambda;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * lambda
 *
 * @author xiejiemin
 * @create 2020/9/24
 */
public class PredicateOfLambda {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                // 判断入参是否等于1
                return Objects.equals(integer, 1);
            }
        };
        boolean test = integerPredicate.test(1);
        if(test){
            System.out.println("这个数是1");
            return;
        }
        System.out.println("这个数不是1");
    }
}
