package dev.thinke.structure;

import java.util.Optional;

public class Stack<T extends Comparable<T>> {
    private final UnsortedLinkedList<T> list; // = new UnsortedLinkedList<>();

    public Stack() {
        this.list = new UnsortedLinkedList<>();
    }

    public Stack(final UnsortedLinkedList<T> list) {
        this.list = list;
    }

    public Stack<T> push(T value) {
        list.insertFirst(value);
        return this;
    }

    public Optional<T> pop() {
        return list.removeFirst();
    }
}
