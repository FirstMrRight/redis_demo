package com.tea.modules.java8.collection.prevent;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * com.xjm.collection.prevent<br>
 * 对集合对象进行操作，最好重写equals和hashcode,避免带来不好的影响<br>
 *
 * @author xiejiemin
 * @create 2020/12/25
 */
@Slf4j
public class EqualsAndHashCode {

    public static class Student implements Comparable<Student>{
        /**
         * 姓名
         */
        private String name;
        /**
         * 性别:0-man|1-women
         */
        private Integer gender;

        public Student(String name, Integer gender) {
            this.name = name;
            this.gender = gender;
        }

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student student = (Student) obj;
                return Objects.equals(this.name, student.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + gender;
            return result;
        }

        @Override
        public int compareTo(Student student) {
            return this.gender - student.gender;
        }
    }

    /**
     * <h2>实现/不实现equals和hashcode对于判等的影响</h2>
     */
    private static void beforeOverrideEqualsAndHashCode() {
        Student jackA = new Student("Jack", 20);
        Student jackB = new Student("Jack", 20);
        log.info("Before override equals and hashcode->{}", Objects.equals(jackA,jackB));
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(jackA);
        studentSet.add(jackB);
        studentSet.forEach(System.out::println);
        Map<Student,Integer> studentMap = new HashMap<>();
        studentMap.put(jackA,20);
        studentMap.put(jackB,20);
        System.out.println(studentMap.size());
    }

    /**
     * <h3>类实现了compareTo方法，就需要实现equals方法</h3>
     * <h3>compareTo与equals的实现过程需要同步</h3>
     */
    private static void compareToWithEquals(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jack",10));
        students.add(new Student("Jack",20));

        Student jack = new Student("Jack", 20);
        // equals
        int studentIndex = students.indexOf(jack);
        // compareTo
        int index = Collections.binarySearch(students, jack);

        System.out.println(studentIndex+"   "+index);
    }
    public static void main(String[] args) {
        beforeOverrideEqualsAndHashCode();
        compareToWithEquals();
    }
}
