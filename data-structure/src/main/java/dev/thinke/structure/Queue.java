package dev.thinke.structure;

import java.util.Optional;

public class Queue<T extends Comparable<T>> {
    private final UnsortedLinkedList<T> list; // = new UnsortedLinkedList<>();

    public Queue() {
        this.list = new UnsortedLinkedList<>();
    }

    public Queue(final UnsortedLinkedList<T> list) {
        this.list = list;
    }

    public void enqueue(T value) {
        list.insertFirst(value);
    }

    public Optional<T> dequeue() {
        return list.removeLast();
    }
}
