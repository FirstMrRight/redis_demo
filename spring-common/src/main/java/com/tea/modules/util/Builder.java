package com.tea.modules.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 通用的 Builder 模式构建器
 *
 * @author: CipherCui
 * @since 2019/8/29
 */
public class Builder<T> {
    private final Supplier<T> supplier;
    private List<Consumer<T>> modifiers = new ArrayList<>();
    public Builder(Supplier<T> supplier) {
        this.supplier = supplier;
    }
    public static <T> Builder<T> of(Supplier<T> supplier) {
        return new Builder<>(supplier);
    }
    public <P1> Builder<T> with(ConsumerA<T, P1> consumer, P1 p1) {
        Consumer<T> c = instance -> consumer.accept(instance, p1);
        modifiers.add(c);
        return this;
    }
    public <P1, P2> Builder<T> with(ConsumerB<T, P1, P2> consumer, P1 p1, P2 p2) {
        Consumer<T> c = instance -> consumer.accept(instance, p1, p2);
        modifiers.add(c);
        return this;
    }
    public <P1, P2, P3> Builder<T> with(ConsumerC<T, P1, P2, P3> consumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> c = instance -> consumer.accept(instance, p1, p2, p3);
        modifiers.add(c);
        return this;
    }
    public T build() {
        T value = supplier.get();
        modifiers.forEach(modifier -> modifier.accept(value));
        modifiers.clear();
        return value;
    }
    /**
     * 1 参数 Consumer
     */
    @FunctionalInterface
    public interface ConsumerA<T, P1> {
        void accept(T t, P1 p1);
    }
    /**
     * 2 参数 Consumer
     */
    @FunctionalInterface
    public interface ConsumerB<T, P1, P2> {
        void accept(T t, P1 p1, P2 p2);
    }
    /**
     * 3 参数 Consumer
     */
    @FunctionalInterface
    public interface ConsumerC<T, P1, P2, P3> {
        void accept(T t, P1 p1, P2 p2, P3 p3);
    }
}