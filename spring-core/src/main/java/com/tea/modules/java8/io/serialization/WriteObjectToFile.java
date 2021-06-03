package com.tea.modules.java8.io.serialization;

import com.alibaba.fastjson.JSON;
import com.tea.modules.model.po.Car;
import com.tea.modules.model.po.Engine;
import com.tea.modules.model.po.Student;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.math.BigDecimal;

/**
 * com.tea.serialization<br>
 * 将对象序列化后写入文件.<br>
 * 将串流stream连接起来代表来源与目的地的连接。<br>
 * 这也就是为什么要先创建 FileOutputStream 再使用 ObjectOutputStream进行写入的原因<br>
 * FileOutputStream作为连接文件的流，仅支持字节级别的操作.<br>
 * 而 ObjectOutputStream则支持对象转化成可以写入串流的数据,此时对象会被转化成stream进入FileOutputStream来写入文件<br>
 * 从面向对象的设计上来讲，FileOutputStream 和 ObjectOutputStream 都遵循单一职责.使用者通过组合调用的方式来使用Java的IO流.<br>
 * Student->ObjectOutputStream处理，将对象碾平->FileOutputStream处理，对象被当作字节处理->ser文件(目的地)<br>
 *
 * @author xiejiemin
 * @create 2021/1/18
 */
@Slf4j
public class WriteObjectToFile {

    public static final String SER_PATH = "C:\\Users\\jaymin\\Desktop\\MyObject.ser";

    /**
     * 单个对象进行序列化
     *
     * @throws IOException
     */
    public static void singleWrite() throws IOException {
        Student jack = Student.builder().age(20).name("Jack").build();
        Student mary = Student.builder().age(30).name("Mary").build();
        serializable(jack);
        serializable(mary);
    }

    public static void serializable(Object object) throws IOException {
        try (
                // 创建文件输出流，如果fileName不存在会自动创建
                // 对象状态序列化.ser文件
                FileOutputStream fileOutputStream = new FileOutputStream(SER_PATH);
                // 对象输出流，可以写入对象，但是无法直接连接文件，需要fileOutputStream作为媒介
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // 将对象写入文件，注意，这里不实现序列化接口会报错->NotSerializableException
            objectOutputStream.writeObject(object);
            log.info("serializable finish.");
        } catch (IOException exception) {
            log.error("An exception occurred while writing to the serialized file");
        }
    }

    /**
     * 复合对象序列化，当car被序列化时，其引用的Engine也会自动序列化，这个过程是自动化的.
     */
    public static void polymerizationObject() throws IOException {
        Car car = Car.builder()
                .name("帕萨特")
                .engine(Engine.builder()
                        .name("无引擎")
                        .price(BigDecimal.ONE).build())
                .build();
        serializable(car);
    }

    /**
     * 反序列化对象，从序列化文件中读取字节，通过流读取还原对象.
     */
    public static void deserialization() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(SER_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Car car = (Car) objectInputStream.readObject();
            log.info("deserialize the object from the serialized file,object : \n {}", JSON.toJSON(car));
        } catch (IOException | ClassNotFoundException exception) {
            log.info("An exception occurred while reading the serialized file,error info:", exception);
        }
    }

    public static void main(String[] args) throws IOException {
//        polymerizationObject();
        deserialization();
    }
}
