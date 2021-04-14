package com.tea.modules.common;

import com.tea.modules.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.tea.modules.util.FileUtil.getFileTypeByFile;
import static com.tea.modules.util.FileUtil.getImageFileType;

/**
 * @author jaymin
 * 2021/2/27 20:26
 */
public class FileUtilTest {

    @Test
    public void testFileType() throws FileNotFoundException {
        File file = new File("C:\\Users\\95152\\Desktop\\Git\\BIO.jpg");
        if (file.exists()) {
            String filetype1 = getImageFileType(file);
            System.out.println(filetype1);
            String filetype2 = getFileTypeByFile(file);
            System.out.println(filetype2);
        }
    }
}
