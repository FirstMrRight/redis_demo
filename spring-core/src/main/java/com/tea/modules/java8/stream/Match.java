package com.tea.modules.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Match {
    public static void main(String[] args) {
        Product productA = new Product("iPhone11", BigDecimal.valueOf(5499),BigDecimal.valueOf(1.7),1);
        Product productB = new Product("HUAWEI P40", BigDecimal.valueOf(4188),BigDecimal.valueOf(2),2);
        Product productC = new Product("OPPO Find X", BigDecimal.valueOf(6999),BigDecimal.valueOf(1.1),5);
        Product productD = new Product("SAMSUNG", BigDecimal.valueOf(8888),BigDecimal.valueOf(2.5),3);
        List<Product> products = Arrays.asList(productA, productB, productC, productD);
        //所有商品钟是否存在小米手机
        System.out.println(products.stream().noneMatch(product -> "xiaomi".equals(product.getNo())));
        //是否存在三星手机
        System.out.println(products.stream().anyMatch(product -> "SAMSUNG".equals(product.getNo())));
        //是否所有手机的重量都大于1KG
        System.out.println(products.stream().anyMatch(product ->product.getWeight().compareTo(BigDecimal.ONE)==1));
    }
}
