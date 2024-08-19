package dev.thinke.structure;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Container<T> {

    void doWhen(Consumer<T> consumer, Predicate<T> predicate);
    void insert(T t);
    Container<T> remove(T t);
    T max();
    T min();
    T predecessor(T t);
    T successor(T t);
}
