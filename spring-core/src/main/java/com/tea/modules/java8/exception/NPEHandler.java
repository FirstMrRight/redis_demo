package com.tea.modules.java8.exception;

import java.io.*;

/**
 * @author jaymin
 */
public class NPEHandler {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("C:\\Users\\95152\\Desktop\\sql.txt");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = bufferedReader.readLine();
            System.out.println(readLine);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 这里的bufferedReader可能为空，直接调用close可能会报错
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
