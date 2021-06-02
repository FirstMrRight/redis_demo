package com.tea.modules.java8.exception;

import com.tea.modules.model.po.User;

import java.io.*;
import java.util.List;

/**
 * @author jaymin
 */
public class NPEHandler {
    public static void main(String[] args) {
//        instanceNotFound();
//        collectionNull();
//        nullReader();
        npeOfBoxing();
    }

    /**
     * 回收资源的时候，没对IO流进行判空
     */
    private static void nullReader() {
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

    /**
     * 对查询的数据不做判空导致的NPE
     */
    private static void instanceNotFound(){
        User user = getDataById(100);
        // 如果根据id:100无法查询到具体的User实例，那么此时的user就是null,那么null.getxxx()就会触发NPE了
        String userName = user.getUserName();
    }

    /**
     * 集合操作时没有进行判空，导致程序报NPE
     */
    private static void collectionNull(){
        List<User> userList = User.getNullInstances();
        System.out.println(userList.size());
    }

    private static User getDataById(int i) {
        return null;
    }

    /**
     * 空String引发的异常
     */
    private static void blankString(){
        String result = getDataFromCache("user:info");
        // 如果从缓存中拿不到数据，进行数据库访问回种
        if(result != null){
            // get data from mysql
        }
    }

    private static String getDataFromCache(String s) {
        return "";
    }

    /**
     * 包装类型拆箱引发的空指针异常
     */
    private static void npeOfBoxing(){
        Integer number = null;
        int result = number;
    }
}
