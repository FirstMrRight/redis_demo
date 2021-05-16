package com.tea.modules.enums;

import lombok.Getter;

/**
 * com.tea.modules.enums
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Getter
public enum DeleteEnum {
    /**
     * 未删除
     */
    NO_DELETE(0),
    /**
     * 已删除
     */
    DELETE(1);

    private Integer isDelete;

    DeleteEnum(int isDelete) {
        this.isDelete = isDelete;
    }
}
