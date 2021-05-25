package com.tea.modules.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.tea.modules.excel.StringToLocalDateTimeConvert;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.tea.modules.model
 *
 * @author xiejiemin
 * @create 2021/3/4
 */
@Data
public class ImportBean {

    @ExcelProperty(index = 0)
    private String one;

    @ExcelProperty(index = 1,converter = StringToLocalDateTimeConvert.class)
    private LocalDateTime date;

    @ExcelProperty(index = 2)
    private String three;
}
