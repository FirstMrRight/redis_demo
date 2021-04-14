package com.tea.modules.design.eventlistener.pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jaymin<br>
 * 事件对象.<br>
 * 2021/1/11 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    private String message;

}
