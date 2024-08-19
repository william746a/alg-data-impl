package dev.thinke.structure;

class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }

    Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
