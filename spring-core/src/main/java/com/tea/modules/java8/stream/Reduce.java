package com.tea.modules.java8.stream;

import com.tea.modules.model.po.StudentForLambda;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
//        Product productA = new Product("iPhone11", BigDecimal.valueOf(5499),BigDecimal.valueOf(1.7),1);
//        Product productB = new Product("HUAWEI P40", BigDecimal.valueOf(4188),BigDecimal.valueOf(2),2);
//        Product productC = new Product("OPPO Find X", BigDecimal.valueOf(6999),BigDecimal.valueOf(1.1),5);
//        Product productD = new Product("SAMSUNG", BigDecimal.valueOf(8888),BigDecimal.valueOf(2.5),3);
//        List<Product> products = Arrays.asList(productA, productB, productC, productD);
//        System.out.println(products.stream().map(Product::getNum).reduce((a, b) -> a + b).get());
//        System.out.println(products.stream().map(Product::getPrice).reduce((a, b) -> a.add(b)).get());
//        System.out.println(products.stream().map(Product::getWeight).reduce((a, b) -> a.add(b)).get());

        StudentForLambda studentA = new StudentForLambda(1L, "特朗普", 45, "漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L, "大雄", 30, "日本");
        StudentForLambda studentC = new StudentForLambda(3L, "拿破仑", 60, "法国");
        StudentForLambda studentD = new StudentForLambda(4L, "孙中山", 25, "中国");
        List<StudentForLambda> studentList = Arrays.asList(studentA, studentB, studentC, studentD);
        String s = studentList.stream().reduce(
                new StringBuffer(), (result, value) ->{
                    System.out.println(result+"我是result");
                    System.out.println(value.toString());
                    return result.append(value.getId()).append(",").append(value.getName()).append(",");
                },
                (result, value) -> result
        ).toString();
        s = s.substring(0,s.length()-1);
        System.out.println(s);
//        String s1 = studentList.stream().reduce(new StringBuffer(), (result, student) ->
//                        result.append(student.getId()).append(",").append(student.getName()).append(","),
//                        (result, student) -> result).toString();
//        System.out.println(s1);
    }
}
