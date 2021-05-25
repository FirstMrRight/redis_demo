package com.tea.modules.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.xjm.model
 *
 * @author xiejiemin
 * @create 2020/12/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScanCodeInfo {
    private String scanType;
    private String scanResult;
}
