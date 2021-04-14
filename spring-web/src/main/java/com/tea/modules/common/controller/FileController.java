package com.tea.modules.common.controller;

import com.tea.modules.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jaymin
 * 2021/2/27 20:34
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("type")
    public String getFileType(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return String.format("current file type is : [%s]", FileUtil.getFileTypeByStream(multipartFile.getBytes()));
    }
}
