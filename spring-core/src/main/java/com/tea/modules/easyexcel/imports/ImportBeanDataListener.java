package com.tea.modules.easyexcel.imports;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.tea.modules.enums.ExceptionEnums;
import com.tea.modules.exception.RestfulException;
import com.tea.modules.model.ImportBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class ImportBeanDataListener extends AnalysisEventListener<ImportBean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportBeanDataListener.class);
    /**
     * 每隔500条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 500;
    List<ImportBean> list = new ArrayList<ImportBean>();

    @Override
    public void invoke(ImportBean data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }

    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     *
     * @param exception
     * @param context
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        Integer rowIndex = context.readRowHolder().getRowIndex();
        String exceptionMsg = String.format("第%s行填写格式有误，请检查!", rowIndex + 1);
        throw new RestfulException(ExceptionEnums.EXCEL_EXCEPTION,exceptionMsg);
    }
}
