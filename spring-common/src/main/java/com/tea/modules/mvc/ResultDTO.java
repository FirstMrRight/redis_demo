package com.tea.modules.mvc;

import com.tea.modules.enums.ExceptionEnums;
import com.tea.modules.exception.RestfulException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Optional;

/**
 * @author jaymin.<br>
 * 对接口响应数据进行统一封装对象.<br>
 * 2021/2/21 20:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 错误提示
     */
    private String error;

    /**
     * 将异常转化成错误的响应对象
     * @param restfulException 系统顶层异常
     * @return error object
     */
    public static ResultDTO toError(RestfulException restfulException) {
        return ResultDTO.builder()
                .code(restfulException.getCode())
                .error(Optional.ofNullable(restfulException.getError()).orElse(restfulException.getMsg()))
                .msg(restfulException.getMsg())
                .data(Collections.emptyMap())
                .build();
    }

    /**
     * 封装响应体，带有数据data
     * @param resultObject data
     * @return success object
     */
    public static ResultDTO toSuccess(Object resultObject) {
        return ResultDTO.builder()
                .code(ExceptionEnums.SUCCESS.getCode())
                .msg(ExceptionEnums.SUCCESS.getMsg())
                .data(Optional.ofNullable(resultObject).orElse(Collections.emptyMap()))
                .build();
    }

}
