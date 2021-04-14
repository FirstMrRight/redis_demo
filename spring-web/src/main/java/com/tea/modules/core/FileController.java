package com.tea.modules.core;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * com.jay.company.file
 *
 * @author xiejiemin
 * @create 2020/9/27
 */
@RestController("coreFileController")
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/download")
    public void downloadFileFromCos() throws IOException {
        String url = "";
        URL httpsUrl = new URL(url);
        String fileName = "测试.png";
        File file = new File("C:/Users/jaymin/Desktop/file/" + fileName);
        log.info("文件名:{}",file.getName());
        log.info("开始下载");
        FileUtils.copyURLToFile(httpsUrl, file);
        MultipartFile forObject = restTemplate.getForObject(url, MultipartFile.class);
        log.info(forObject.toString());
    }

    @GetMapping("/tranUrlToFile")
    public MultipartFile getFile(@RequestParam("url") String url, @RequestParam("fileName") String fileName) {
        FileItem item = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(30000);
            conn.setConnectTimeout(30000);
            //设置应用程序要从网络连接读取数据
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (InputStream is = conn.getInputStream()) {
                    try (OutputStream os = item.getOutputStream()) {
                        FileItemFactory factory = new DiskFileItemFactory(1024 * 100, null);
                        item = factory.createItem(fileName, "application/octet-stream", false, fileName);
                        int bytesRead = 0;
                        byte[] buffer = new byte[1024 * 100];
                        while ((bytesRead = is.read(buffer, 0, buffer.length)) != -1) {
                            os.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("文件下载失败", e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(item);
        return multipartFile;
    }
}
