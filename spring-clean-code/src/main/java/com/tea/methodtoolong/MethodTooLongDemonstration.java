package com.tea.methodtoolong;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tea.modules.exception.RestfulException;
import com.tea.modules.model.request.ExchangeInfoRequest;
import com.tea.modules.model.response.ExchangeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * com.tea.methodtoolong<br>
 * 方法写太长，可读性较低
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Component
@Slf4j
public class MethodTooLongDemonstration {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String URL = "http://demo/v6/lasted";
    private static final List<String> exchangeCodeSortList = new ArrayList<>();

    static {
        exchangeCodeSortList.add("USD");
        exchangeCodeSortList.add("CHY");
        exchangeCodeSortList.add("HK");
    }

    public ExchangeResponse getExchangeInfoOfTooLong(String exchangeCode) {
        if (StringUtils.isEmpty(exchangeCode)) {
            return new ExchangeResponse();
        }
        Object cacheResult = redisTemplate.opsForValue().get(exchangeCode);
        if (Objects.nonNull(cacheResult)) {
            String jsonString = JSON.toJSONString(cacheResult);
            ExchangeResponse exchangeResponse = JSONObject.parseObject(jsonString, ExchangeResponse.class);
            return exchangeResponse;
        }
        ExchangeInfoRequest exchangeInfoRequest = new ExchangeInfoRequest();
        exchangeInfoRequest.setExchangeCode(exchangeCode);
        exchangeInfoRequest.setUpdateTime(new Date());
        ExchangeResponse exchangeResponse = null;
        long startTime = System.currentTimeMillis();
        log.info("request api :[{}],params:{}", URL, JSON.toJSONString(exchangeInfoRequest));
        try {
            exchangeResponse = restTemplate.getForObject(URL, ExchangeResponse.class, exchangeInfoRequest);
            long endTime = System.currentTimeMillis();
            log.info("request api :[{}] uses {} ms", URL, endTime - startTime);
        } catch (RestClientException e) {
            throw new RestfulException("调用:[" + URL + "]api出错,错误原因:" + e);
        }
        if (Objects.isNull(exchangeResponse)) {
            return new ExchangeResponse();
        }
        Map<String, Object> resultMap = new TreeMap();
        for (Map.Entry<String, Object> conversionRate : exchangeResponse.getConversionRates().entrySet()) {
            String currentExchangeCode = conversionRate.getKey();
            Object currentExchange = conversionRate.getValue();
            int index = exchangeCodeSortList.indexOf(currentExchangeCode);
            resultMap.put(Integer.valueOf(index).toString(), currentExchange);
        }
        exchangeResponse.setConversionRates(resultMap);
        redisTemplate.opsForValue().set("exchange:cache", JSON.toJSONString(exchangeResponse), 30, TimeUnit.MINUTES);
        return exchangeResponse;
    }

    public ExchangeResponse getExchangeInfo(String exchangeCode) {
        if (StringUtils.isEmpty(exchangeCode)) {
            return new ExchangeResponse();
        }
        Object cacheResult = redisTemplate.opsForValue().get(exchangeCode);
        if (Objects.nonNull(cacheResult)) {
            String jsonString = JSON.toJSONString(cacheResult);
            ExchangeResponse exchangeResponse = JSONObject.parseObject(jsonString, ExchangeResponse.class);
            return exchangeResponse;
        }
        ExchangeResponse exchangeResponse = requestExchangeInfo(exchangeCode);
        if (Objects.isNull(exchangeResponse)) {
            return new ExchangeResponse();
        }
        Map<String, Object> resultMap = new TreeMap();
        for (Map.Entry<String, Object> conversionRate : exchangeResponse.getConversionRates().entrySet()) {
            String currentExchangeCode = conversionRate.getKey();
            Object currentExchange = conversionRate.getValue();
            int index = exchangeCodeSortList.indexOf(currentExchangeCode);
            resultMap.put(Integer.valueOf(index).toString(), currentExchange);
        }
        exchangeResponse.setConversionRates(resultMap);
        redisTemplate.opsForValue().set("exchange:cache", JSON.toJSONString(exchangeResponse), 30, TimeUnit.MINUTES);
        return exchangeResponse;
    }
    @Cacheable(key = "#exchangeCode", value = "exchange:cache", unless = "#result == null")
    public ExchangeResponse queryExchangeInfo(String exchangeCode) {
        ExchangeResponse exchangeResponse = requestExchangeInfo(exchangeCode);
        return exchangeResponse;
    }

    private ExchangeResponse requestExchangeInfo(String exchangeCode) {
        ExchangeInfoRequest exchangeInfoRequest = ExchangeInfoRequest.init(exchangeCode);
        ExchangeResponse exchangeResponse = null;
        long startTime = System.currentTimeMillis();
        log.info("request api :[{}],params:{}", URL, JSON.toJSONString(exchangeInfoRequest));
        try {
            exchangeResponse = restTemplate.getForObject(URL, ExchangeResponse.class, exchangeInfoRequest);
            long endTime = System.currentTimeMillis();
            log.info("request api :[{}] uses {} ms", URL, endTime - startTime);
        } catch (RestClientException e) {
            throw new RestfulException("调用:[" + URL + "]api出错,错误原因:" + e);
        }
        if (Objects.isNull(exchangeResponse)) {
            return new ExchangeResponse();
        }
        sortExchangeCode(exchangeResponse);
        return exchangeResponse;
    }

    private void sortExchangeCode(ExchangeResponse exchangeResponse) {
        TreeMap<String, Object> resultMap = exchangeResponse.getConversionRates().entrySet().stream()
                .sorted(Comparator.comparingInt(exchangeCodeSortList::indexOf))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        TreeMap::new));
        exchangeResponse.setConversionRates(resultMap);
    }
}
