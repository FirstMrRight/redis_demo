package com.tea.modules.util;

import com.tea.modules.exception.RestfulException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jaymin
 * 2021/2/27 20:24
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {
    /**
     * 文件类型映射表
     */
    private static final Map<String, String> fileTypeMap = new HashMap<>();

    static {
        // 初始化文件类型信息
        getAllFileType();
    }

    /**
     * <p>常见文件头信息初始化</p>
     *
     */
    private static void getAllFileType() {
        // JPEG (jpg)
        fileTypeMap.put("jpg", "FFD8FF");
        // PNG (png)
        fileTypeMap.put("png", "89504E47");
        // GIF (gif)
        fileTypeMap.put("gif", "47494638");
        // TIFF (tif)
        fileTypeMap.put("tif", "49492A00");
        // Windows Bitmap (bmp)
        fileTypeMap.put("bmp", "424D");
        // CAD (dwg)
        fileTypeMap.put("dwg", "41433130");
        // HTML (html)
        fileTypeMap.put("html", "68746D6C3E");
        // Rich Text Format (rtf)
        fileTypeMap.put("rtf", "7B5C727466");
        fileTypeMap.put("xml", "3C3F786D6C");
        fileTypeMap.put("zip", "504B0304");
        fileTypeMap.put("rar", "52617221");
        // Photoshop (psd)
        fileTypeMap.put("psd", "38425053");
        // Email [thorough only] (eml)
        fileTypeMap.put("eml", "44656C69766572792D646174653A");
        // Outlook Express (dbx)
        fileTypeMap.put("dbx", "CFAD12FEC5FD746F");
        // Outlook (pst)
        fileTypeMap.put("pst", "2142444E");
        // MS Word
        fileTypeMap.put("xls", "D0CF11E0");
        // MS Excel 注意：word 和 excel的文件头一样
        fileTypeMap.put("doc", "D0CF11E0");
        // MS Access (mdb)
        fileTypeMap.put("mdb", "5374616E64617264204A");
        // WordPerfect (wpd)
        fileTypeMap.put("wpd", "FF575043");
        fileTypeMap.put("eps", "252150532D41646F6265");
        fileTypeMap.put("ps", "252150532D41646F6265");
        // Adobe Acrobat (pdf)
        fileTypeMap.put("pdf", "255044462D312E");
        // Quicken (qdf)
        fileTypeMap.put("qdf", "AC9EBD8F");
        // Windows Password (pwl)
        fileTypeMap.put("pwl", "E3828596");
        // Wave (wav)
        fileTypeMap.put("wav", "57415645");
        fileTypeMap.put("avi", "41564920");
        // Real Audio (ram)
        fileTypeMap.put("ram", "2E7261FD");
        // Real Media (rm)
        fileTypeMap.put("rm", "2E524D46");
        fileTypeMap.put("mpg", "000001BA");
        // Quicktime (mov)
        fileTypeMap.put("mov", "6D6F6F76");
        // Windows Media (asf)
        fileTypeMap.put("asf", "3026B2758E66CF11");
        // MIDI (mid)
        fileTypeMap.put("mid", "4D546864");
    }

    /**
     * @param file
     * @return fileType
     */
    public static String getImageFileType(File file) {
        if (isImage(file)) {
            try(ImageInputStream imageInputStream = ImageIO.createImageInputStream(file)) {
                Iterator<ImageReader> iter = ImageIO.getImageReaders(imageInputStream);
                if (!iter.hasNext()) {
                    return StringUtils.EMPTY;
                }
                ImageReader reader = iter.next();
                return reader.getFormatName();
            } catch (Exception e) {
                return StringUtils.EMPTY;
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取文件类型,包括图片,若格式不是已配置的,则返回空字符串
     *
     * @param file 文件
     * @return fileType
     */
    public static String getFileTypeByFile(File file) {
        String filetype;
        byte[] b = new byte[50];
        try (InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(b);
            filetype = getFileTypeByStream(b);
        } catch (IOException e) {
            throw new RestfulException("resolved the file type error:", e);
        }
        return filetype;
    }

    /**
     * 获取当前字节流的文件类型
     *
     * @param byteStream 字节流
     */
    public final static String getFileTypeByStream(byte[] byteStream) {
        String filetypeHex = String.valueOf(getFileHexString(byteStream));
        return fileTypeMap.entrySet().stream()
                .filter(entry -> {
                    if (filetypeHex.toUpperCase().startsWith(entry.getValue())) {
                        return true;
                    }
                    return false;
                })
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(StringUtils.EMPTY);
    }

    /**
     * 当前文件是否为图片
     *
     * @param file 判断文件是否为图片
     * @return true 是 | false 否
     */
    public static boolean isImage(File file) {
        boolean flag = false;
        try {
            BufferedImage bufferReader = ImageIO.read(file);
            int width = bufferReader.getWidth();
            int height = bufferReader.getHeight();
            if (width == 0 || height == 0) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (Exception ignored) {
        }
        return flag;
    }

    /**
     * 将二进制流转化成16进制
     *
     * @param bytes 二进制流
     */
    public static String getFileHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
