package dev.thinke.structure;

import java.util.Optional;

public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    public SortedLinkedList() {
    }

    public SortedLinkedList(DeletionStrategy<T> deletionStrategy) {
        super(deletionStrategy);
    }

    // does an insertion sort as items are added
    @Override
    public void insert(T t) {
        var currentNode = first;
        if (currentNode == null) {
            currentNode = new Node<>(t);
            first = currentNode;
            last = currentNode;
            size = 1;
        } else {
            while (currentNode != null) {
                var left = currentNode.getLeft();
                var right = currentNode.getRight();
                // currentNode is first node; new node goes first
                if (left == null && currentNode.getValue().compareTo(t) > 0) {
                    var newNode = new Node<>(t);
                    newNode.setRight(currentNode);
                    currentNode.setLeft(newNode);
                    first = newNode;
                    size++;
                    break;
                } else
                    // currentNode is last node; new node goes last
                    if (right == null && (currentNode.getValue().compareTo(t) < 0 ||
                            currentNode.getValue().compareTo(t) == 0)) {
                    var newNode = new Node<>(t);
                    newNode.setLeft(currentNode);
                    currentNode.setRight(newNode);
                    last = newNode;
                    size++;
                    break;
                } else
                    // new node goes in between currentNode and currentNode.left
                    if (left != null && ((left.getValue().compareTo(t) < 0 && currentNode.getValue().compareTo(t) > 0) ||
                            (left.getValue().compareTo(t) == 0))) {
                    var newNode = new Node<>(t);
                    newNode.setLeft(left);
                    newNode.setRight(currentNode);
                    currentNode.setLeft(newNode);
                    left.setRight(newNode);
                    size++;
                    break;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    @Override
    public T max() {
        return last.getValue();
    }

    @Override
    public T min() {
        return first.getValue();
    }

    @Override
    public T predecessor(T t) {
        final Optional<Node<T>> itemNode = find(t);
        return itemNode.map(Node::getLeft).map(Node::getValue).orElse(null);
    }

    @Override
    public T successor(T t) {
        final Optional<Node<T>> itemNode = find(t);
        return itemNode.map(Node::getRight).map(Node::getValue).orElse(null);
    }

    private void link(Node<T> newNode, Node<T> leftNode, Node<T> rightNode) {
        leftNode.setRight(newNode);
        newNode.setLeft(leftNode);
        newNode.setRight(rightNode);
        rightNode.setLeft(newNode);
    }
}
