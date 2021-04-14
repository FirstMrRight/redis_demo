package com.tea.modules.bean.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin
 * 2021/1/9 0:12
 */
@Configuration
public class PostProcessorConfiguration {

    @Bean
    public GlobalEventBus eventBus() {
        return GlobalEventBus.getInstance();
    }

    @Bean
    public GuavaEventBusBeanPostProcessor eventBusBeanPostProcessor() {
        return new GuavaEventBusBeanPostProcessor();
    }

    @Bean
    public StockTradePublisher stockTradePublisher() {
        return new StockTradePublisher();
    }
}