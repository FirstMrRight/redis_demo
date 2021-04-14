package com.tea.modules.easyexcel.imports;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * easyExcel导入监听器
 *
 * @author xiejiemin
 * @since 2021/3/29
 */
@Slf4j
public class TicketCodeImportListener extends AnalysisEventListener<TicketCode> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;
    /**
     * 需要导入的票码列表
     */
    List<TicketCode> ticketCodePOList = new ArrayList<>();


    @Override
    public void invoke(TicketCode ticketCodePO, AnalysisContext context) {
        if (Objects.isNull(ticketCodePO)) {
            return;
        }
        ticketCodePOList.add(ticketCodePO);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (ticketCodePOList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            ticketCodePOList.clear();
        }
    }

    /**
     * 入库
     */
    private void saveData() {
        String json = JacksonUtils.toJsonString(ticketCodePOList);
        log.info("json:{}", json);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("导入票码成功!");
    }


}
