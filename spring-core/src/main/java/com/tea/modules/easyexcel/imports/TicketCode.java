package com.tea.modules.easyexcel.imports;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * com.tea.modules.easyexcel.imports
 *
 * @author xiejiemin
 * @since 2021/3/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCode {
    /**
     * 票码
     */
    @ExcelProperty(index = 0)
    private String ticketCode;

    /**
     * 证件类型
     */
    @ExcelProperty(index = 1)
    private String credType;
}
