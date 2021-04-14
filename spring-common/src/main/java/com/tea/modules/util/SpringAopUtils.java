package com.tea.modules.util;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Supplier;

/**
 * com.tea.spring.util<br>
 * aop解析专用<br>
 *
 * @author xiejiemin
 * @create 2021/1/15
 */
@SuppressWarnings("all")
public class SpringAopUtils {
    /**
     * SPEL表达式解析器
     */
    private static SpelExpressionParser spelExpressionParser;
    /**
     * 参数获取器
     */
    private static DefaultParameterNameDiscoverer parameterNameDiscoverer;

    static {
        spelExpressionParser = new SpelExpressionParser();
        parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
    }

    /**
     * 获取切点方法上的注解类
     * @param joinPoint 切点
     * @param clazz 函数式接口，你可以这样传参->String.class
     * @param <T>
     * @return Annotation
     */
    public static <T extends Annotation> T getAnnotation(JoinPoint joinPoint, Class<? extends Annotation> clazz) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Annotation annotation = method.getAnnotation(clazz);
        return (T) annotation;
    }

    /**
     * 获取切点方法对象
     * @param joinPoint 切点
     * @param <T>
     * @return Method
     */
    public static <T extends Method> T getMethod(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return (T) method;
    }

    /**
     * 获取方法参数
     * @param joinPoint 切点
     * @return
     */
    public static Object[] getArgs(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        return args;
    }

    /**
     * 根据声明的SPEL解析出参数信息
     *
     * @param annotationParam 表达式对应的注解Field
     * @param joinPoint 切点
     * @param supplier 函数式
     * @return
     */
    public static  <T> T parseSpelExpression(String annotationParam, JoinPoint joinPoint, Supplier<?> supplier) {
        Object[] args = getArgs(joinPoint);
        if (StringUtils.isBlank(annotationParam)) {
            return null;
        }
        // 获取被拦截方法参数名列表
        String[] paraNameArray = parameterNameDiscoverer.getParameterNames(getMethod(joinPoint));

        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        // 把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArray.length; i++) {
            context.setVariable(paraNameArray[i], args[i]);
        }
        return (T) spelExpressionParser.parseExpression(annotationParam).getValue(context, supplier.get().getClass());
    }


    /**
     * 根据声明的SPEL解析出参数信息.
     * 支持模板SPEL解析.你可以这样使用:
     * #{#yourSpelExpression}
     * @param annotationParam 表达式对应的注解Field
     * @param joinPoint 切点
     * @param supplier 函数式
     * @return
     */
    public static  <T> T parseSpelExpressionOfTemplate(String annotationParam, JoinPoint joinPoint, Supplier<?> supplier) {
        Object[] args = getArgs(joinPoint);
        if (StringUtils.isBlank(annotationParam)) {
            return null;
        }
        // 获取被拦截方法参数名列表
        String[] paraNameArray = parameterNameDiscoverer.getParameterNames(getMethod(joinPoint));

        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        // 把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArray.length; i++) {
            context.setVariable(paraNameArray[i], args[i]);
        }
        return (T) spelExpressionParser.parseExpression(annotationParam,new TemplateParserContext()).getValue(context, supplier.get().getClass());
    }
}
