package com.tea.modules.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tea.modules.enums.ExceptionEnums;
import com.tea.modules.exception.RestfulException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jaymin
 * 2021/2/12 22:00
 */
@Slf4j
public class JacksonUtils {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
    }

    public static <T> String toJsonString(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("An exception occurred when the object was serialized into JSON,error message:{}", e);
            throw new RestfulException(ExceptionEnums.TO_JSON_ERROR);
        }
    }
}
