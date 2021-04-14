package com.tea.modules.mvc;

import com.google.common.collect.Maps;
import com.tea.modules.mvc.HttpRequestWrapper;
import com.tea.modules.util.HttpUtil;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

/**
 * com.tea.modules.config.<br>
 * 应用日志打印类,负责打印当前系统接口的http报文信息与统计响应时间.<br>
 *
 * @author xiejiemin
 * @create 2021/2/20
 */
@Slf4j
@Component
public class ApplicationLog {

    /**
     * 接口进入时间
     */
    private static final ThreadLocal<LocalDateTime> httpStartTime = new ThreadLocal<>();
    /**
     * 如果http传输的内容过长，不打印
     */
    @Value("${com.tea.http.maxContentLength:5000}")
    private Long configMaxContextLength;
    /**
     * 静态变量，通过@PostConstruct赋值，便于复用
     */
    private static Long maxContextLength;

    @PostConstruct
    public void setMaxContextLength() {
        maxContextLength = configMaxContextLength;
    }


    /**
     * 发起请求时打印入参信息，以及将开始时间通过ThreadLocal进行存储
     *
     * @param requestWrapper httpServletRequestWrapper包装类,从中可以获取报文信息
     */
    public static synchronized void logHttpRequest(HttpRequestWrapper requestWrapper) {
        httpStartTime.set(LocalDateTime.now());
        String path = requestWrapper.getServletPath();
        // todo: 可以增加忽略的路径,例如:/swagger,/druid,/info,/health...
        int contentLength = requestWrapper.getContentLength();
        if (contentLength > maxContextLength) {
            log.info("content length is too long.");
            return;
        }
        String requestMessage = requestWrapper.toString();
        if (StringUtils.isBlank(requestMessage)) {
            return;
        }
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("Method", requestWrapper.getMethod());
        map.put("Path", path);
        map.put("Host", HttpUtil.getIpAddress(requestWrapper));
        map.put("Content-Length", contentLength);
        map.put("Cookies", requestWrapper.getCookies());
        map.put("Referer", requestWrapper.getHeader("Referer"));
        map.put("Content-Type", requestWrapper.getContentType());
        map.put("User-Agent", requestWrapper.getHeader("User-Agent"));
        log.debug("current request:\n{},\nrequest message:{}", JacksonUtils.toJsonString(map), requestMessage);
    }

    /**
     * 日志记录响应体信息,并且计算出当前接口的响应时间.
     *
     * @param response 响应体
     */
    public static synchronized void logHttpResponse(Object response) {
        if (Objects.isNull(response)) {
            return;
        }
        // file
        if (response instanceof byte[]) {
            return;
        }
        String resultMessage;
        if(response instanceof String){
            resultMessage = (String) response;
        }else {
            resultMessage = JacksonUtils.toJsonString(response);
        }
        if (resultMessage.length() > maxContextLength) {
            log.debug("resultMessage length is too long.");
            logExecuteTime();
            return;
        }
        log.debug("http response message:\n{}", resultMessage);
        logExecuteTime();
    }

    /**
     * 日志打印响应时间，从本地线程变量中获取开始时间，使用Duration做时间差值计算
     */
    private static void logExecuteTime() {
        try {
            Optional.ofNullable(httpStartTime.get()).ifPresent(startTime -> {
                LocalDateTime endTime = LocalDateTime.now();
                long executeTime = Duration.between(startTime, endTime).toMillis();
                log.debug("execute uses {} ms", executeTime);
            });
        } finally {
            // 防止内存溢出
            httpStartTime.remove();
        }
    }
}
