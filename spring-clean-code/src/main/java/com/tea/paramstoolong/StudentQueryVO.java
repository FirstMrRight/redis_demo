package com.tea.paramstoolong;

import lombok.Data;

import java.util.Date;

/**
 * com.tea.paramstoolong
 * 使用对象封装查询参数
 * @author jaymin
 * @since 2021/5/15
 */
@Data
public class StudentQueryVO {
    private String studentName;
    private String school;
    private Date createTime;
    private Long page;
    private Long pageSize;
    private Integer age;
}
