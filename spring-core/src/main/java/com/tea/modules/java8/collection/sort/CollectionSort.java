package com.tea.modules.java8.collection.sort;

import com.google.common.collect.Lists;
import com.tea.modules.model.Student;
import com.tea.modules.util.JacksonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jaymin.<br>
 * 在一次使用lambda的时候对Java排序产生了兴趣。因此本demo用来研究集合排序.<br>
 * 2021/2/18 20:16
 */
@SuppressWarnings("unchecked")
public class CollectionSort {
    /**
     * 数字列表
     */
    protected final static List<Integer> numberList = Lists.newArrayList(2, 3, 4, 1, 5, 2, 5, 6, 7, 99);
    /**
     * 存储不同年龄段的学生列表
     */
    protected static List<Student> studentList;

    public static void main(String[] args) {
        sortByStreamWithNullFirst();
    }


    /**
     * 构建出学生列表参数
     */
    private static void createStudentList() {
        Student xiaoMing = Student.builder().age(20).name("20岁的小明").build();
        Student xiaoHong = Student.builder().age(22).name("22岁的小红").build();
        Student xiaoHua = Student.builder().age(25).name("25岁的小华").build();
        studentList = Lists.newArrayList(xiaoHong, xiaoMing, xiaoHua);
    }

    /**
     * 使用Collections.sort对集合进行升序排序.<br>
     * 要求集合中的对象实现Comparable接口.<br>
     */
    public static void sortByCollections() {
        Collections.sort(numberList);
        numberList.forEach(e -> System.out.print(e + "-"));
    }

    /**
     * 这里我们使用了集合存储学生的信息.<br>
     * 如果此时希望按照年龄来进行排序，可以在Student类中实现Comparable接口。<br>
     * 然后再使用Collections.sort进行排序.<br>
     */
    public static void sortByCollectionsComparable() {
        createStudentList();
        Collections.sort(studentList);
        studentList.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
    }

    /**
     * 不实现接口，使用比较器-Comparator来进行排序.<br>
     * 比较器接收两个参数,可以理解成，给定两个学生对象，你实现compare方法来规定按什么顺序进行排序.<br>
     * 比较规则:the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y.<br>
     * 首先我们通过匿名内部类来完成这项工作.<br>
     *
     * @see Comparator
     */
    public static void sortByCollectionsComparator() {
        createStudentList();
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student studentA, Student studentB) {
                return Integer.compare(studentA.getAge(), studentB.getAge());
            }
        });
        studentList.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
    }

    /**
     * 在Java8中，你可以使用lambda来简化匿名内部类.<br>
     */
    public static void sortByCollectionsComparatorInJava8() {
        createStudentList();
        // 常规的lambda
        Collections.sort(studentList, (studentA, studentB) -> Integer.compare(studentA.getAge(), studentB.getAge()));
        // 同时，你可以将这种方式改写成方法引用
        Collections.sort(studentList, Comparator.comparingInt(Student::getAge));
        studentList.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
    }

    /**
     * 使用Java8的stream流，让你的集合操作更多元化.<br>
     */
    public static void sortByStream() {
        createStudentList();
        // 升序
        List<Student> result = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());
        result.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
        System.out.println("------------reversedOrder---------------");
        // 倒序
        List<Student> reversedOrderResult = studentList.stream()
                .sorted(Comparator.comparingInt(Student::getAge).reversed())
                .collect(Collectors.toList());
        reversedOrderResult.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
    }

    /**
     * 使用null值保护比较器来避免空指针异常<br>
     */
    public static void sortByStreamWithNullFirst() {
        createStudentList();
        studentList.get(0).setAge(null);
        // 升序,空值排在第一位
        List<Student> result = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge,Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        result.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
        System.out.println("******************** Null First reverseOrderResult*****************************");
        // 降序,空值排在第一位
        List<Student> reverseOrderResult = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge,Comparator.nullsFirst(Comparator.reverseOrder())))
                .collect(Collectors.toList());
        reverseOrderResult.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
        System.out.println("******************** Null Last reverseOrderResult*****************************");
        // 降序,空值排在第一位
        List<Student> nullLastResult = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge,Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
        nullLastResult.forEach(e -> System.out.print(JacksonUtils.toJsonString(e) + "\n"));
    }
}
