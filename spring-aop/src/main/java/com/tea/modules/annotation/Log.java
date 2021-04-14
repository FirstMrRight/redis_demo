package com.tea.modules.annotation;

import java.lang.annotation.*;

/**
 * com.tea.annotation
 *
 * @author xiejiemin
 * @create 2021/1/14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
    /**
     * 可以传入SPEL进行解析
     * @return
     */
    String value() default "";
}
