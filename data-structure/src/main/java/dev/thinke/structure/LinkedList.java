package dev.thinke.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

abstract class LinkedList<T extends Comparable<T>> implements Container<T> {

    protected Node<T> first;
    protected Node<T> last;
    Integer size = Integer.valueOf(0);
    private final DeletionStrategy<T> deletionStrategy;

    protected LinkedList() {
        this.deletionStrategy = new DeleteAll<>();
    }

    protected LinkedList(DeletionStrategy<T> deletionStrategy) {
        this.deletionStrategy = deletionStrategy;
    }

    public Integer size() {
        return size;
    }

    public LinkedList<T> remove(T item) {
        deletionStrategy.delete(this, item);
        return this;
    }

    public void forEach(Consumer<T> consumer) {
        var currentNode = first;
        while(currentNode != null) {
            consumer.accept(currentNode.getValue());
            currentNode = currentNode.getRight();
        }
    }

    public List<T> asList() {
        var list = new ArrayList<T>(size);
        this.forEach(list::add);
        return list;
    }

    @Override
    public void doWhen(Consumer<T> consumer, Predicate<T> predicate) {
        var currentNode = first;
        while(currentNode != null) {
            if (predicate.test(currentNode.getValue())) {
                consumer.accept(currentNode.getValue());
            }
            currentNode = currentNode.getRight();
        }
    }

    public void doAtIndex(Consumer<T> consumer, Integer index) {
        var currentNode = first;
        var counter = 0;
        // if we went with this approach, we'd need to guard against an index out of bounds
//        for (int i = 0; i < size; i++) {
//            if (index.equals(i)) {
//                consumer.accept(currentNode.getItem());
//                break;
//            } else {
//                currentNode = currentNode.right;
//            }
//        }
        while (currentNode != null) {
            if (index.equals(counter)) {
                consumer.accept(currentNode.getValue());
                break;
            } else {
                currentNode = currentNode.getRight();
                counter++;
            }
        }
    }

    protected Optional<Node<T>> find(T item) {
        var currentNode = first;
        while(currentNode != null) {
            if (currentNode.getValue().equals(item)) {
                return Optional.of(currentNode);
            }
            currentNode = currentNode.getRight();
        }
        return Optional.empty();
    }

    protected void forEachNode(Consumer<Node<T>> consumer) {
        var currentNode = first;
        while(currentNode != null) {
            consumer.accept(currentNode);
            currentNode = currentNode.getRight();
        }
    }

    Node<T> deleteNode(Node<T> node) {
        var priorNode = node.getLeft();
        var nextNode = node.getRight();
        if (priorNode != null) {
            priorNode.setRight(nextNode);
        } else {
            first = nextNode;
        }
        if (nextNode != null) {
            nextNode.setLeft(priorNode);
        } else {
            last = priorNode;
        }
        size--;
        return node;
    }
}
