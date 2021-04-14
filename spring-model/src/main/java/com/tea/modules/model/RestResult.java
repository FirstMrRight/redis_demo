package com.tea.modules.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jaymin<br>
 * 泛型基类
 * 2020/11/6 18:19
 */
@Data
public class RestResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static boolean resultDataIsNull(RestResult<?> restResult) {
        return Objects.isNull(restResult.getCode()) || Objects.isNull(restResult.getMsg()) || Objects.isNull(restResult.getData());
    }
}