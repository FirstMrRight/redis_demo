package com.tea.modules.java8.thread.threadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * com.xjm.thread.threadLocal
 *
 * @author xiejiemin
 * @create 2020/12/14
 */
@SuppressWarnings("all")
public final class ThreadLocalUtils {
    private static final ThreadLocal<Map<String, Object>> ThreadLocalMap = ThreadLocal.withInitial(HashMap::new);

    private ThreadLocalUtils() {
    }

    public static Map<String, Object> getAll() {
        return (Map) ThreadLocalMap.get();
    }

    public static <T> T put(String key, T value) {
        ((Map) ThreadLocalMap.get()).put(key, value);
        return value;
    }

    public static void remove(String key) {
        ThreadLocalMap.get().remove(key);
    }

    public static void clear() {
        ThreadLocalMap.remove();
    }

    public static <T> T get(String key) {
        return (T) ThreadLocalMap.get().get(key);
    }

    public static <T> T get(String key, Supplier<T> supplierOnNull) {
        return (T) ThreadLocalMap.get().computeIfAbsent(key, k -> supplierOnNull.get());
    }

    public static <T> T getAndRemove(String key) {
        Object value;
        try {
            value = get(key);
        } finally {
            remove(key);
        }

        return (T) value;
    }
}
