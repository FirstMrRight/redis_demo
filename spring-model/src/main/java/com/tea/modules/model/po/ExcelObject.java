package com.tea.modules.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * com.tea.modules.model
 *
 * @author xiejiemin
 * @create 2021/1/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelObject implements Serializable {

    @ExcelProperty(value = "用户名",index = 0)
    private String userName;

    @ExcelProperty(value = "年龄",index = 1)
    private Integer age;

    @ExcelProperty(value = "职业",index = 2)
    private String job;
}
