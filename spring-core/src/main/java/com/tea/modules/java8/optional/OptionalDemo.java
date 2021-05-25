package com.tea.modules.java8.optional;

import com.tea.modules.model.po.Car;
import com.tea.modules.model.po.Student;

import java.util.Objects;
import java.util.Optional;

/**
 * Optional类<br>
 * 作用：用于判断对象是否存在<br>
 * 不能作为field存在与对象中<br>
 * 不实现序列化接口<br>
 */
@SuppressWarnings("all")
public class OptionalDemo {
    public static void demo() {

        String nullString = null;
        // 使用ofNullable创建一个Optional
        Optional<String> optionalString = Optional.ofNullable(nullString);
        // 如果Optional内的值为null,那么将匹配orElse中的值
        String result = optionalString.orElse("");
        System.out.println(Objects.equals(result, null));

        String resultString = Optional.ofNullable(nullString).orElseGet(() -> emptyString());
        System.out.println(Objects.equals(result, null));

//        optionalString.ofNullable(nullString).orElseThrow(() -> new RuntimeException("这个字符串是空的!"));
        String existString = "DWG 3:1 SN";
        Optional.ofNullable(existString).ifPresent(s -> {
            System.out.println("S10总决赛的比分是:" + s);
        });

        if (optionalString.isPresent()) {
            System.out.println(optionalString.get());
        }
        // 对null的对象使用了of构造器
//        Optional<String> errorThing = Optional.of(nullString);

        String errorMethod = Optional.ofNullable(nullString).get();
    }

    public static void main(String[] args) {
        optionalOfNullMap();
    }

    /**
     * <p>如果你有一个需求:</p>
     * <pre>{@code
     * handle(Car car){
     *      // do something...
     * }
     * }</pre>
     *
     * <p>此时Car中有Engine对象，你希望获取一下Engine中的name属性，但是不确定Car是否为空,那么Optional可以帮助你进行嵌套判空.</p>
     */
    private static void optionalOfNullMap() {
        Integer integer = Optional.ofNullable(new Student()).map(student -> student.getAge()).orElse(0);
        Optional.ofNullable(new Car())
                .map(car -> car.getEngine())
                .map(engine -> engine.getName())
                .orElse("");
        System.out.println(integer);
    }

    // 这里以String进行举例，实际开发中这个可能是一个对象的初始化工厂方法
    public static String emptyString() {
        return "";
    }

}
