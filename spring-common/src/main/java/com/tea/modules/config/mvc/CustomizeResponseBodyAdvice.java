package com.tea.modules.config.mvc;

import com.tea.modules.mvc.ApplicationLog;
import com.tea.modules.exception.RestfulException;
import com.tea.modules.mvc.ResultDTO;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * com.tea.modules.config.<br>
 * 用户自定义响应报文切面,用于封装统一的响应报文结构.<br>
 * 拦截@RestController、@RestControllerAdvice标记的类返回的信息.<br>
 *
 * @author xiejiemin
 * @create 2021/2/20
 */
@Configuration
@ControllerAdvice(annotations = {RestController.class, RestControllerAdvice.class})
@Slf4j
public class CustomizeResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    /**
     * 什么情况下启用beforeBodyWrite，默认为启用状态
     * @param methodParameter 方法参数对象
     * @param converterType converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 在框架进行body写入前进行响应体改造
     * @param resultObject controller返回的实体对象或者抛出的异常
     * @param methodParameter 方法参数
     * @param mediaType 通过内容协商选择的内容类型
     * @param selectedConverterType 选择要写入响应的转换器类型
     * @param serverHttpRequest 请求体
     * @param serverHttpResponse 响应体
     * @return 自定义的统一封装响应对象
     */
    @Override
    public Object beforeBodyWrite(Object resultObject, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResultDTO<?> result;
        if (resultObject instanceof RestfulException) {
            RestfulException exception = (RestfulException) resultObject;
            if (exception.isFail()) {
                log.error("application error message:", exception);
            }
            result = ResultDTO.toError(exception);
        }
        else if (resultObject instanceof byte[]) {
            return resultObject;
        }
        else if (resultObject instanceof String){
            ApplicationLog.logHttpResponse(resultObject);
            return JacksonUtils.toJsonString(ResultDTO.toSuccess(resultObject));
        }
        else {
            result = ResultDTO.toSuccess(resultObject);
        }
        ApplicationLog.logHttpResponse(result);
        return result;
    }
}
