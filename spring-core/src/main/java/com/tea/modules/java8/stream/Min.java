package com.tea.modules.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Min {
    public static void main(String[] args) {
        Product productA = new Product("iPhone11", BigDecimal.valueOf(5499),BigDecimal.valueOf(1.7),1);
        Product productB = new Product("HUAWEI P40", BigDecimal.valueOf(4188),BigDecimal.valueOf(2),2);
        Product productC = new Product("OPPO Find X", BigDecimal.valueOf(6999),BigDecimal.valueOf(1.1),5);
        Product productD = new Product("SAMSUNG", BigDecimal.valueOf(8888),BigDecimal.valueOf(2.5),3);
        List<Product> products = Arrays.asList(productA, productB, productC, productD);
        System.out.println(products.stream().min(Comparator.comparing(Product::getWeight)).get().toString());
        System.out.println(products.stream().max(Comparator.comparing(Product::getWeight)).get().toString());
    }
}
