package dev.thinke.structure;

abstract class Delete<T extends Comparable<T>> extends DeletionStrategy<T> {

    Node<T> delete(LinkedList<T> list, T item, Boolean all) {
        var currentNode = list.first;
        while (currentNode != null) {
            if (currentNode.getValue().equals(item)) {
                currentNode = list.deleteNode(currentNode).getRight();
                if (!all) {
                    break;
                }
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return currentNode;
    }
}
