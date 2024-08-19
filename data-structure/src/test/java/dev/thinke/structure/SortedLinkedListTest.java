package dev.thinke.structure;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedLinkedListTest {

    @Test
    void testInsert() {
        var list = new SortedLinkedList<Integer>();
        var testList = List.of(2, 2, 3, 4, 5, 6, 6, 7, 8, 8);
        for (Integer item : List.of(8, 5, 7, 2, 4, 6, 3, 8, 2, 6)) {
            list.insert(item);
        }
        list.forEach(System.out::println);
        assertEquals(testList, list.asList());
        assertEquals(10, list.size());
    }

    @Test
    void testRemove_all() {
        var list = new SortedLinkedList<Integer>(new DeleteAll<>());
        var testList = List.of(2, 2, 3, 4, 5, 7, 8, 8);
        for (Integer item : List.of(8, 5, 7, 2, 4, 6, 3, 8, 2, 6)) {
            list.insert(item);
        }
        assertEquals(testList, list.remove(6).asList());
        assertEquals(8, list.size());
    }

    @Test
    void testRemove_first() {
        var list = new SortedLinkedList<Integer>(new DeleteFirst<>());
        var testList = List.of(2, 2, 3, 4, 5, 6, 7, 8, 8);
        for (Integer item : List.of(8, 5, 7, 2, 4, 6, 3, 8, 2, 6)) {
            list.insert(item);
        }
        assertEquals(testList, list.remove(6).asList());
        assertEquals(9, list.size());
    }
}
