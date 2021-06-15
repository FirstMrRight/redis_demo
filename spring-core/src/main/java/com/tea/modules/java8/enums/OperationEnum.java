package com.tea.modules.java8.enums;

import lombok.Getter;

/**
 * com.tea.modules.java8.enums <br>
 * 运算符枚举
 *
 * @author jaymin
 * @since 2021/6/10
 */
@Getter
public enum OperationEnum {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationEnum(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);
}
