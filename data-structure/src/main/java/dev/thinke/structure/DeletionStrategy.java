package dev.thinke.structure;

abstract class DeletionStrategy<T extends Comparable<T>> {

    abstract Node<T> delete(LinkedList<T> container, T item);
}
