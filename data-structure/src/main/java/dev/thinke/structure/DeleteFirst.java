package dev.thinke.structure;

public class DeleteFirst<T extends Comparable<T>> extends Delete<T> {

    @Override
    Node<T> delete(LinkedList<T> list, T item) {
        return super.delete(list, item, false);
    }
}
