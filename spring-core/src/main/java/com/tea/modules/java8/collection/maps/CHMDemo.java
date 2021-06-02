package com.tea.modules.java8.collection.maps;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * com.tea.modules.java8.collection.maps
 *
 * @author jaymin
 * @since 2021/5/9
 */
public class CHMDemo {
    public static void main(String[] args) {/*
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A","小明");
        concurrentHashMap.put("B","小红");
        System.out.println(concurrentHashMap.remove("A"));
        */
        HashMap hashMap = new HashMap();
        hashMap.put("1",2);
        Object orDefault = hashMap.getOrDefault("11", 1);
        System.out.println(orDefault.toString());

    }
}
