package com.tea.modules.http.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileInputStream;

public class TestUpload {
    public static void main(String[] args) throws Exception {
        long curr = System.currentTimeMillis();
        Connection connect = Jsoup.connect("");
        FileInputStream fis = new FileInputStream("C:\\Users\\95152\\Desktop\\自研Spring框架\\第8章 精讲SpringIoC容器的依赖注入 【攻坚Bean实例的创建】\\8-2 夺取doGetBean之从缓存获取Bean.mp4");
        connect.data("file[]", "test.mp4", fis);
        Document doc = connect.ignoreContentType(true).timeout(0).maxBodySize(0).post();
        String text = doc.body().text();
        System.out.println(text);
        fis.close();
        System.out.println(System.currentTimeMillis() - curr);
    }
}
