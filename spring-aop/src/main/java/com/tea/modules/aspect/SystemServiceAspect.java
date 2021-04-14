package com.tea.modules.aspect;

import com.tea.modules.exception.RestfulException;
import com.tea.modules.introduction.CustomizeProcessor;
import com.tea.modules.introduction.TeaProcessor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author jaymin. <br>
 * 系统基础切面，主要用于研究AOP.
 * 2021/2/12 20:56
 */
@Aspect
@Slf4j
//@Component
public class SystemServiceAspect {

    @DeclareParents(value = "com.tea..controller..*", defaultImpl = TeaProcessor.class)
    public CustomizeProcessor customizeProcessor;

    /**
     * 使用常量统一管理切入点
     */
    public static final String SYSTEM_SERVICE_POINT_CUT = "systemServicePointCut()";

    /**
     * <p>pointcut可以使用表达式来指定切入点.
     * <p>execution中的内容即为表达式.</p>
     * <p>* com.tea..service..*.*(..)</p>
     * <p>表示,拦截com.tea包下的service包中的所有类的所有方法(包括任意参数)
     */
    @Pointcut("execution(* com.tea..service..*.*(..))")
    public void systemServicePointCut() {
    }

    /**
     * 在方法执行前进行切入
     * @param joinPoint
     */
    @Before(SYSTEM_SERVICE_POINT_CUT)
    public void before(JoinPoint joinPoint) {
        log.info("before {} method execute ", this.getMethodName(joinPoint));
    }

    /**
     * 环绕整个方法的执行
     * @param joinPoint
     * @return
     */
    @Around(SYSTEM_SERVICE_POINT_CUT)
    public Object around(JoinPoint joinPoint) {
        LocalDateTime startTime = LocalDateTime.now();
        log.info("around {} method starts at :{}", this.getMethodName(joinPoint), startTime);
        Object result;
        try {
            result = ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable throwable) {
            throw new RestfulException(throwable);
        } finally {
            LocalDateTime endTime = LocalDateTime.now();
            long executeTime = Duration.between(startTime, endTime).toMillis();
            log.info("{} method using : {} ms", this.getMethodName(joinPoint), executeTime);
        }
        return result;
    }

    /**
     * 在方法返回值后进行切入
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = SYSTEM_SERVICE_POINT_CUT, returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} method return : {}", this.getMethodName(joinPoint), result);
    }

    /**
     * 在方法抛出异常后进行切入
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = SYSTEM_SERVICE_POINT_CUT, throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.error("current {} method throw an exception,message:{}", this.getMethodName(joinPoint), exception.getMessage());
    }

    /**
     * 获取连接点方法名
     * @param joinPoint
     * @return
     */
    public String getMethodName(JoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
    }

    /**
     * 在方法执行后进行切入
     * @param joinPoint
     */
    @After(SYSTEM_SERVICE_POINT_CUT)
    public void after(JoinPoint joinPoint) {
        log.info("after {} method execute", this.getMethodName(joinPoint));
    }
}
