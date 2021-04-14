package com.tea.modules.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * com.tea.modules.config.<br>
 * servlet拦截器
 * @author xiejiemin
 * @create 2021/2/20
 */
@Component
@Order(0)
@Slf4j
public class RequestFilter implements Filter, InitializingBean {

    /**
     * 在servlet请求中进行拦截,将请求信息进行包装用于日志记录.<br>
     * @param servletRequest 请求体
     * @param servletResponse 响应体
     * @param filterChain 职责链中的
     * @throws IOException 过滤器使用FilterChain来调用链中的下一个过滤器
     * @throws ServletException servlet异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            //复制请求
            HttpRequestWrapper req  = new HttpRequestWrapper((HttpServletRequest)servletRequest);
            ApplicationLog.logHttpRequest(req);
            filterChain.doFilter(req, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void afterPropertiesSet() {
        log.info("loading framework log filter");
    }
}
