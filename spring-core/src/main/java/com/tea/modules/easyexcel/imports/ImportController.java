package com.tea.modules.easyexcel.imports;

import com.alibaba.excel.EasyExcel;
import com.tea.modules.model.po.ImportBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * com.tea.modules.easyexcel.imports
 *
 * @author xiejiemin
 * @create 2021/3/4
 */
@RestController
@RequestMapping("/tea/import")
@Slf4j
public class ImportController {

    @PostMapping("")
    public void read(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            EasyExcel.read(inputStream, ImportBean.class, new ImportBeanDataListener()).sheet().doRead();
        }
    }

    @PostMapping("/ticket")
    public void readTicket(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            EasyExcel.read(inputStream, TicketCode.class, new TicketCodeImportListener()).sheet().doRead();
        }
    }
}
