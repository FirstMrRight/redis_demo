package com.tea.modules.bean.event;

import com.google.common.eventbus.EventBus;
import com.tea.modules.bean.event.aspect.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionException;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.function.BiConsumer;

/**
 * @author jaymin<br>
 * 现在，我们将定义BeanPostProcessor，它将检查每个bean的订户注释。<br>
 * 此类也是DestructionAwareBeanPostProcessor，它是一个Spring接口，向BeanPostProcessor添加了销毁前的回调。<br>
 * 如果注释存在，我们会通过解析注解上的SPEL表达式来影响bean的初始化与销毁的过程<br>
 * 接受每个bean并通过下面定义的process方法运行它。<br>
 * 它在Bean初始化之后和销毁之前对其进行处理。<br>
 * 该requiresDestruction方法返回默认值是true，我们保持这种行为这里我们检查了存在@subscriber在注释postProcessBeforeDestruction回调。<br>
 * 2021/1/9 0:00
 */
@Slf4j
public class GuavaEventBusBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    SpelExpressionParser expressionParser = new SpelExpressionParser();

    /**
     * 销毁前取消订阅
     *
     * @param bean
     * @param beanName
     * @throws BeansException
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName)
            throws BeansException {
        this.process(bean, EventBus::unregister, "destruction");
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    /**
     * 初始化后推送注册事件
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        this.process(bean, EventBus::register, "initialization");
        return bean;
    }

    /**
     * 该代码检查是否存在名为Subscriber的自定义标记批注，如果存在，则从其value属性读取SpEL表达式。<br>
     * 然后，将表达式求值到对象中。如果它的一个实例EventBus， 我们应用BiConsumer函数参数的bean。<br>
     * 该BiConsumer用于注册和注销从豆EventBus。<br>
     * @param bean
     * @param consumer
     * @param action
     */
    private void process(Object bean, BiConsumer<EventBus, Object> consumer, String action) {
        // See implementation below
        Object proxy = this.getTargetObject(bean);
        Subscriber annotation = AnnotationUtils.getAnnotation(proxy.getClass(), Subscriber.class);
        if (annotation == null) {
            return;
        }
        log.info("{}: processing bean of type {} during {}",
                this.getClass().getSimpleName(), proxy.getClass().getName(), action);
        String annotationValue = annotation.value();
        try {
            Expression expression = this.expressionParser.parseExpression(annotationValue);
            Object value = expression.getValue();
            if (!(value instanceof EventBus)) {
                log.error(
                        "{}: expression {} did not evaluate to an instance of EventBus for bean of type {}",
                        this.getClass().getSimpleName(), annotationValue, proxy.getClass().getSimpleName());
                return;
            }
            EventBus eventBus = (EventBus) value;
            consumer.accept(eventBus, proxy);
        } catch (ExpressionException ex) {
            log.error("{}: unable to parse/evaluate expression {} for bean of type {}",
                    this.getClass().getSimpleName(), annotationValue, proxy.getClass().getName());
        }
    }

    private Object getTargetObject(Object proxy) throws BeansException {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            try {
                return ((Advised) proxy).getTargetSource().getTarget();
            } catch (Exception e) {
                throw new FatalBeanException("Error getting target of JDK proxy", e);
            }
        }
        return proxy;
    }
}
