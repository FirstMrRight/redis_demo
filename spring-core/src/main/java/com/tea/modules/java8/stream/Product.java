package com.tea.modules.java8.stream;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String no;
    private BigDecimal price;
    private BigDecimal weight;
    private Integer num;


    public Product() {
    }

    public Product(String no, BigDecimal price, BigDecimal weight, Integer num) {
        this.no = no;
        this.price = price;
        this.weight = weight;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return no.equals(product.no) &&
                price.equals(product.price) &&
                weight.equals(product.weight) &&
                num.equals(product.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, price, weight, num);
    }

    @Override
    public String toString() {
        return "Product{" +
                "no='" + no + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", num=" + num +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
