package com.tea.modules.model.base;

import com.tea.modules.enums.DeleteEnum;
import lombok.Data;

import java.util.Date;

/**
 * com.tea.modules.model
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Data
public class BaseModel {
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private Integer hasDelete;

    public void initialize(String userId) {
        Date now = new Date();
        this.createUser = userId;
        this.updateUser = updateUser;
        this.createTime = now;
        this.updateTime = now;
        this.hasDelete = DeleteEnum.DELETE.getIsDelete();
    }
}
