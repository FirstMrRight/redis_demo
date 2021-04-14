package com.tea.modules.data.redis.core.limit.support;

/**
 * @author jaymin<br>
 * 限流器<br>
 * 2020/12/21 23:30
 */
public interface RateLimiter {

    /**
     * 本次请求是否在限流次数内
     * @param requestEvent 请求事件，作为Redis存储的key值
     * @param period 时间窗，即需要在多少时间范围内限制该行为
     * @param maxRequestCount 最大请求次数
     * @return
     */
    boolean isAllowed(String requestEvent,int period,int maxRequestCount);
}
