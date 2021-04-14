package com.tea.modules.java8.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * com.xjm.string
 *
 * @author xiejiemin
 * @create 2020/12/28
 */
public class toStringDemo {
    public static void main(String[] args) throws IOException {
        String str = "202012";
        String substring = str.substring(4, 6);
        System.out.println(substring);
        File file = new File("C:\\Users\\jaymin\\Desktop\\temp","a.text");
        if(!file.exists()){
            File parentFile = file.getParentFile();
            parentFile.mkdir();
            file.createNewFile();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
          fileWriter.write("我可以创建文件夹!");
        }
    }

    public static void test(String a){
        a= "1";
    }
}
