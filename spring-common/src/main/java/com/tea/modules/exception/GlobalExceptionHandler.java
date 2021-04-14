package com.tea.modules.exception;

import com.alibaba.excel.exception.ExcelAnalysisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * com.tea.modules.config.<br>
 * 全局异常类拦截器.<br>
 * @author xiejiemin
 * @create 2021/2/20
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new RestfulException(e);
    }

    @ExceptionHandler(RestfulException.class)
    public RestfulException handleRestException(RestfulException e) {
        return e;
    }

    @ExceptionHandler(ExcelAnalysisException.class)
    public RestfulException handleRestException(ExcelAnalysisException e) {
        return new RestfulException(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
        return new RestfulException(e);
    }
}
