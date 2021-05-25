package com.tea.modules.easyexcel.export;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.google.common.collect.Lists;
import com.tea.modules.model.po.ExcelObject;
import com.tea.modules.constant.Constants;
import com.tea.modules.enums.ExceptionEnums;
import com.tea.modules.exception.RestfulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * com.tea.io.excel
 *
 * @author xiejiemin
 * @create 2021/1/20
 */
@RestController
@RequestMapping("/tea/export")
@Slf4j
public class ExportController {

    @GetMapping("")
    public void export(HttpServletResponse response) {
        ExcelObject one = ExcelObject.builder().age(10).job("HR").userName("超人").build();
        ExcelObject two = ExcelObject.builder().age(20).job("拳击手").userName("超人").build();
        ArrayList<ExcelObject> excelObjects = Lists.newArrayList(one, two);
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        //设置 垂直居中
        headWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置 水平居中
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        try (ServletOutputStream out = response.getOutputStream()) {
            String fileName = "测试EasyExcel.xlsx";
            String encode = URLEncoder.encode(fileName, Constants.UTF_8);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader(Constants.CONTENT_DISPOSITION, "attachment;filename=" + encode);
            EasyExcel.write(out, ExcelObject.class)
                    .registerWriteHandler(horizontalCellStyleStrategy)
                    .sheet("我是一个sheet")
                    .doWrite(excelObjects);
        } catch (IOException e) {
            log.info("导出excel发生异常", e);
            throw new RestfulException(ExceptionEnums.ERROR);
        }
    }
}
