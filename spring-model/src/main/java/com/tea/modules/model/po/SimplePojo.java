package com.tea.modules.model.po;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

/**
 * @author jaymin
 * 2021/2/14 21:38
 */
@Slf4j
@Service
public class SimplePojo implements Consumer {

    @Override
    public void accept(Object o) {
        log.info("I just do something.");
        this.selfCall();
    }

    /**
     * 在此处，如果调用this.accept()来激活selfCall().<br>
     * 是不会激活Spring的事务管理的.<br>
     * 原因:  <br>
     * Spring是通过代理类来调用targetObject的方法的.<br>
     * 我们在selfCall上标注@Transactional,那么就需要通过代理类来调用这个方法.<br>
     * 想象一下，$ProxySimplePojo中调用accept.未命中切点<br>
     * 此时的引用已经交给SimplePojo这个原本的targetObject了，在SimplePojo调用selfCall并不会触发代理类的通知.<br>
     * 简单来说就是,$ProxySimplePojo只代理了selfCall(),而没有代理accept().<br>
     */
    @Transactional(rollbackFor = Exception.class)
    public void selfCall(){
        log.info("just self call.");
    }
}
