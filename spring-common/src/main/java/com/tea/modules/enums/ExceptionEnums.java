package com.tea.modules.enums;

import lombok.Getter;

/**
 * com.tea.spring.enums.<br>
 * 异常枚举
 * @author xiejiemin
 * @create 2021/1/22
 */
@Getter
public enum ExceptionEnums {

    /**
     * 请求成功响应信息
     */
    SUCCESS(0),
    /**
     * 请求失败响应信息
     */
    ERROR(-1),
    /**
     * JSON序列化异常响应信息
     */
    TO_JSON_ERROR(-2,"序列化JSON出错"),
    /**
     * 用户统一认证失败响应信息
     */
    AUTH_ERROR(-3,"用户统一认证失败"),
    /**
     * 请求方式不支持响应信息
     */
    REQUEST_METHOD_NOT_SUPPORTED(-4,"不支持的请求方法"),
    EXCEL_EXCEPTION(-5,"excel读取失败")
    ;

    /**
     * 响应码
     */
    private final int code;
    /**
     * 响应信息
     */
    private final String msg;

    ExceptionEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ExceptionEnums(Integer code) {
        this.code = code;
        switch(code) {
            case -1:
                this.msg = "网络异常，请稍后再试";
                break;
            case 0:
                this.msg = "执行成功";
                break;
            default:
                this.msg = "undefined";
        }

    }
}
