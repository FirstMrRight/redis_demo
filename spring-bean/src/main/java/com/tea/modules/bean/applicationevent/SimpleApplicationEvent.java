package com.tea.modules.bean.applicationevent;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author jaymin
 * 2021/1/16 23:50
 */
@Builder
public class SimpleApplicationEvent extends ApplicationEvent {
    /**
     * 事件内容
     */
    @Getter
    @Setter
    private String message;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SimpleApplicationEvent(String source) {
        super(source);
        this.message = source;
    }
}
