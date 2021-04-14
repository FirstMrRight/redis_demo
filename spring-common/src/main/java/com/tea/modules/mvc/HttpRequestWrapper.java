package com.tea.modules.mvc;

import com.alibaba.fastjson.JSON;
import com.tea.modules.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Enumeration;

/**
 * com.tea.modules.config.<br>
 * 解决方法:<a href="https://zhuanlan.zhihu.com/p/239948869">解决Required request body is missing</a>
 * @author xiejiemin
 * @create 2021/2/20
 */
public class HttpRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 存储当前请求输入流信息
     */
    private byte[] requestBody;

    /**
     * 增加Body封装类，用来保存requestBody.<br>
     * 如果是文件，忽略当前复制请求
     * @param request 请求体
     * @throws IOException IO异常
     */
    public HttpRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        if (isFileUpload()) {
            return;
        }
        ServletInputStream servletInputStream = request.getInputStream();
        // spring util of io
        this.requestBody = StreamUtils.copyToByteArray(servletInputStream);
    }

    @Override
    public ServletInputStream getInputStream() {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);

        return new ServletInputStream() {

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

    public boolean isFileUpload() {
        return getContentType() != null && getContentType().startsWith(Constants.MULTIPART);
    }

    @Override
    public String toString() {
        if (StringUtils.isBlank(super.getContentType())) {
            return StringUtils.EMPTY;
        }
        String contentType = super.getContentType().toLowerCase();
        String result = null;
        if (isFileUpload()) {
            return StringUtils.EMPTY;
        }
        if (contentType.contains(Constants.JSON)) {
            result = new String(requestBody);
            return JSON.toJSONString(JSON.parseObject(result));
        } else {
            Enumeration<String> parameterNames = super.getParameterNames();
            StringBuilder builder = new StringBuilder();
            while (parameterNames.hasMoreElements()) {
                String key = parameterNames.nextElement();
                builder.append(key);
                builder.append("=");
                String parameter = super.getParameter(key);
                builder.append(parameter);
                builder.append("&");
            }
            if (builder.length() > 1) {
                builder.deleteCharAt(builder.length() - 1);
            }
            result = builder.toString();
        }
        return result;
    }
}
