package com.tea.modules.data;

import com.tea.modules.annotation.Log;
import com.tea.modules.model.Student;
import com.tea.modules.data.redis.core.limit.support.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author jaymin
 * 2020/12/21 1:15
 */
@RestController
@Slf4j
@RequestMapping(value = "/redis")
public class RateLimitController {
    @Resource(name = "fixWindowRateLimiterLoader")
    private RateLimiter rateLimiter;

    private static volatile int allowedCount;

    @GetMapping("/test")
    public String testRateLimiter(){
        allowedCount = 0;
        String key = "jaymin:limit:test";
        for (int i = 0; i < 200; i++) {
            if (rateLimiter.isAllowed(key,60,10)){
                allowedCount++;
            }
        }
        return String.format("The allowed count is %s", allowedCount);
    }

    @Log(value = "I am #{#student.name}")
    @PostMapping("/test/aop")
    public void test(@RequestBody Student student){
        log.info("test");
    }
}
