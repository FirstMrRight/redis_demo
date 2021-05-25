package com.tea.modules.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * com.tea.modules.model<br>
 * 汽车，包含引擎和车胎<br>
 * @author xiejiemin
 * @create 2021/1/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    /**
     * 汽车名称
     */
    private String name;
    /**
     * 引擎
     */
    private Engine engine;
}
