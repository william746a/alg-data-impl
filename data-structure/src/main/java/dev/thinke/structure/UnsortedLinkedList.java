package dev.thinke.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UnsortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    public UnsortedLinkedList() {
        super();
    }

    public UnsortedLinkedList(DeletionStrategy<T> deletionStrategy) {
        super(deletionStrategy);
    }

    public UnsortedLinkedList<T> insertLast(T newItem) {
        if (first == null) {
            first = createAndAttachLast(newItem);
        } else {
            var lastNode = last;
            lastNode.setRight(createAndAttachLast(newItem));
            last.setLeft(lastNode);
        }
        return this;
    }

    private Node<T> createAndAttachLast(T item) {
        var node = new Node<T>(item);
        last = node;
        size++;
        return node;
    }

    public UnsortedLinkedList<T> insertFirst(T newItem) {
        var node = new Node<T>(newItem);
        node.setRight(first);
        if (first != null) {
            first.setLeft(node);
        }
        first = node;
        if (last == null) {
            last = node;
        }
        size++;
        return this;
    }

    public Optional<T> removeFirst() {
        if (first == null) {
            return Optional.empty();
        }
        var node = first;
        first = first.getRight();
        if (first != null) {
            first.setLeft(null);
        }
        if (node == last) {
            last = null;
        }
        size--;
        return Optional.of(node.getValue());
    }

    public Optional<T> removeLast() {
        if (last == null) {
            return Optional.empty();
        }
        var node = last;
        last = last.getLeft();
        if (last != null) {
            last.setRight(null);
        }
        if (node == first) {
            first = null;
        }
        size--;
        return Optional.of(node.getValue());
    }

    @Override
    public void insert(T o) {
        insertLast(o);
    }

    public T max() {
        final AtomicReference<T> max = new AtomicReference<>(first.getValue());
        this.forEach(item -> {
            if (item.compareTo(max.get()) > 0) {
                max.set(item);
            }
        });
        return max.get();
    }

    public T min() {
        final AtomicReference<T> min = new AtomicReference<>(first.getValue());
        this.forEach(item -> {
            if (item.compareTo(min.get()) < 0) {
                min.set(item);
            }
        });
        return min.get();
    }

    public T successor(T original) {
        final AtomicReference<T> succ = new AtomicReference<>();
        this.forEach(item -> {
            if (succ.get() == null) {
                if (item.compareTo(original) > 0) {
                    succ.set(item);
                }
            } else {
                if (item.compareTo(original) > 0 && item.compareTo(succ.get()) < 0) {
                    succ.set(item);
                }
            }
        });
        return succ.get();
    }

    public T predecessor(T original) {
        final AtomicReference<T> pred = new AtomicReference<>();
        this.forEach(item -> {
            if (pred.get() == null) {
                if (item.compareTo(original) < 0) {
                    pred.set(item);
                }
            } else {
                if (item.compareTo(original) < 0 && item.compareTo(pred.get()) > 0) {
                    pred.set(item);
                }
            }
        });
        return pred.get();
    }

//
//    public <R> LinkedList<T> mapAll(Function<T, R> function) {
//
//    }
//
//    public <R> LinkedList<T> mapOnly(Function<T, R> function, Predicate<T> predicate) {
//
//    }

//    private static class Node<T> {
//        private final T item;
//        public Node<T> next;
//        public Node<T> prior;
//
//        public Node(T item) {
//            this.item = item;
//        }
//
//        public T getItem() {
//            return item;
//        }
//    }
}
