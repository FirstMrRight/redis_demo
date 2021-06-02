package com.tea.modules.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * com.tea.modules.model.po <br>
 * 苹果电脑
 *
 * @author jaymin
 * @since 2021/6/2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AppleComputer extends Computer {

    private long price;
    private String color;

    public AppleComputer(Integer id, String name, long price, String color) {
        super(id, name);
        this.price = price;
        this.color = color;
    }

    public AppleComputer(long price, String color) {
        this.price = price;
        this.color = color;
    }
}
