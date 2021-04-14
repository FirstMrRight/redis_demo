package com.tea.modules.aspect;

import com.tea.modules.annotation.Log;
import com.tea.modules.util.SpringAopUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * com.tea.aspectj
 *
 * @author xiejiemin
 * @create 2021/1/14
 */
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.tea.modules.annotation.Log)")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void recordLog(JoinPoint joinPoint) {
        Log logger = SpringAopUtils.getAnnotation(joinPoint, Log.class);
        String value = SpringAopUtils.parseSpelExpressionOfTemplate(logger.value(), joinPoint, String::new);
        log.info("log apspect : {}", value);
    }
}
