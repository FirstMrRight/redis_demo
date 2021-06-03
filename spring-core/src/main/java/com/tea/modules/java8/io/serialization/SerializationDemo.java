package com.tea.modules.java8.io.serialization;

import com.alibaba.fastjson.JSON;
import com.tea.modules.model.po.Car;
import com.tea.modules.model.po.Children;
import com.tea.modules.model.po.Engine;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.math.BigDecimal;

/**
 * com.tea.modules.java8.io.serialization <br>
 * 序列化容易带来的坑
 * @author jaymin
 * @since 2021/6/3
 */
@Slf4j
public class SerializationDemo {

    public static void main(String[] args) throws IOException {
//        children();
        multiSerializeObjects();
    }

    /**
     * 父类不实现序列化，子类可以实现序列化，前提是父类需要有无参构造函数
     * @throws IOException
     */
    private static void children() throws IOException {
        Children children = Children.builder().idCard(11).build();
        WriteObjectToFile.serializable(children);
        deserialization();
    }

    /**
     * 组合的对象，需要实现序列化接口
     * @throws IOException
     */
    public static void polymerizationObject() throws IOException {
        Car car = Car.builder()
                .name("帕萨特")
                .engine(Engine.builder()
                        .name("无引擎")
                        .price(BigDecimal.ONE).build())
                .build();
        WriteObjectToFile.serializable(car);
    }

    /**
     * 多次序列化同一个对象,只会序列化一次,前提是流未关闭
     */
    private static void multiSerializeObjects() throws IOException {
        Children children = Children.builder().idCard(1).build();
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(WriteObjectToFile.SER_PATH);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(children);
            objectOutputStream.writeObject(children);
            children.setIdCard(2);
            objectOutputStream.writeObject(children);
            log.info("serializable finish.");
        } catch (IOException exception) {
            log.error("An exception occurred while writing to the serialized file");
        }
        try (FileInputStream fileInputStream = new FileInputStream(WriteObjectToFile.SER_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Children readChildren = (Children) objectInputStream.readObject();
            log.info("deserialize the object from the serialized file,object : \n {}", JSON.toJSON(readChildren));
        } catch (IOException | ClassNotFoundException exception) {
            log.info("An exception occurred while reading the serialized file,error info:", exception);
        }
    }


    private static void deserialization() {
        try (FileInputStream fileInputStream = new FileInputStream(WriteObjectToFile.SER_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Children children = (Children) objectInputStream.readObject();
            log.info("deserialize the object from the serialized file,object : \n {}", JSON.toJSON(children));
        } catch (IOException | ClassNotFoundException exception) {
            log.info("An exception occurred while reading the serialized file,error info:", exception);
        }
    }
}
