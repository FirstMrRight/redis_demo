package com.tea.modules.model.po;

import com.tea.modules.model.po.ScanCodeInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * com.xjm.model
 * @XStreamAlias
 * @author xiejiemin
 * @create 2020/12/2
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class WeixinXml implements Serializable {
    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
    private String event;
    private String eventKey;
    private ScanCodeInfo scanCodeInfo;
    private Integer agentID;
}
