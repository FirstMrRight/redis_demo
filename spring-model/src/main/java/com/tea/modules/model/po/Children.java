package com.tea.modules.model.po;

import lombok.*;

import java.io.Serializable;

/**
 * @author jaymin<br>
 * 子类<br>
 * 2020/11/29 12:31
 */
@Data
@Builder
@AllArgsConstructor
public class Children extends Parent implements Serializable {

    private Integer idCard;
    public Children(){
        System.out.println("I am Children");
    }
}
