package com.tea.modules.exception;


import com.tea.modules.enums.ExceptionEnums;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * com.tea.spring.exception.<br>
 * 框架顶层异常类
 * @author xiejiemin
 * @create 2021/1/22
 */
@Slf4j
@Data
public class RestfulException extends RuntimeException {
    /**
     * 响应码
     */
    private Integer code = ExceptionEnums.ERROR.getCode();
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 异常信息
     */
    private String error;

    public RestfulException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestfulException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RestfulException(Integer code, String msg, Exception e) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RestfulException(Exception e) {
        super(e.getMessage());
        this.setError(e);
    }

    public RestfulException(Throwable cause) {
        super(cause.getMessage());
    }

    public RestfulException(ExceptionEnums exceptionEnums, String error) {
        super(exceptionEnums.getMsg()+error);
        this.code = exceptionEnums.getCode();
        this.msg = exceptionEnums.getMsg();
        this.error = error;
    }

    public RestfulException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMsg());
        this.code = exceptionEnums.getCode();
        this.msg = exceptionEnums.getMsg();
        this.error = exceptionEnums.getMsg();
    }

    public RestfulException(String message) {
        super(message);
        this.code = ExceptionEnums.ERROR.getCode();
        this.msg = Optional.ofNullable(this.msg).orElse(ExceptionEnums.ERROR.getMsg());
        this.error = message;
    }

    private void setError(Exception e) {
        this.code = ExceptionEnums.ERROR.getCode();
        this.msg = Optional.ofNullable(this.msg).orElse(ExceptionEnums.ERROR.getMsg());
        this.error = toString(e);
    }

    /**
     * 将异常转化为String
     * @param e 异常
     * @return exception message
     */
    public static String toString(Throwable e) {
        log.error("发送异常:",e);
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);) {
            e.printStackTrace(pw);
        }
        return sw.toString();
    }

    /**
     * 是否错误
     * @return isFail
     */
    public boolean isFail() {
        return !Objects.equals(this.code, ExceptionEnums.SUCCESS.getCode());
    }
}
