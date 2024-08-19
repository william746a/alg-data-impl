package dev.thinke.structure;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnsortedLinkedListTest {

    @Test
    void testInsertLast() {
        var list = new UnsortedLinkedList<Integer>();
        var testList = List.of(5, 7, 4, 6, 3, 8, 2);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.asList());
        assertEquals(7, list.size());
    }

    @Test
    void testInsertFirst() {
        var list = new UnsortedLinkedList<Integer>();
        var testList = List.of(2, 8, 3, 6, 4, 7, 5);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertFirst(item);
        }
        assertEquals(testList, list.asList());
        assertEquals(7, list.size());
    }

    @Test
    void testRemoveLast() {
        var list = new UnsortedLinkedList<Integer>();
        var testList = List.of(5, 7, 4, 6, 3, 8);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        var last = list.removeLast();
        assertTrue(last.isPresent());
        assertEquals(2, last.get());
        assertEquals(testList, list.asList());
        assertEquals(6, list.size());
    }

    @Test
    void testRemoveFirst() {
        var list = new UnsortedLinkedList<Integer>();
        var testList = List.of(8, 3, 6, 4, 7, 5);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertFirst(item);
        }
        var first = list.removeFirst();
        assertTrue(first.isPresent());
        assertEquals(2, first.get());
        assertEquals(testList, list.asList());
        assertEquals(6, list.size());
    }

    @Test
    void testDoAtIndex() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        list.doAtIndex(item -> assertEquals(6, item), 3);
    }

    @Test
    void testMax() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(8, list.max());
    }

    @Test
    void testMin() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(2, list.min());
    }

    @Test
    void testSucc() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(3, list.successor(2));
    }

    @Test
    void testSucc_none() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertNull(list.successor(8));
    }

    @Test
    void testPred() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(6, list.predecessor(7));
    }

    @Test
    void testPred_none() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertNull(list.predecessor(2));
    }

    @Test
    void testDeleteFirstOccurrence() {
        var list = new UnsortedLinkedList<Integer>(new DeleteFirst<>());
        var testList = List.of(5, 7, 4, 6, 3, 8, 2);
        for (Integer item : List.of(5, 3, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(3).asList());
    }

    @Test
    void testDeleteFirst_firstOccurance() {
        var list = new UnsortedLinkedList<Integer>(new DeleteFirst<>());
        var testList = List.of(5, 7, 4, 6, 3, 8, 2);
        for (Integer item : List.of(5, 5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(5).asList());
    }

    @Test
    void testDeleteFirst_Occurance_last() {
        var list = new UnsortedLinkedList<Integer>(new DeleteFirst<>());
        var testList = List.of(5, 7, 4, 6, 3, 8, 2);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(2).asList());
    }

    @Test
    void testDeleteAllOccurrences() {
        var list = new UnsortedLinkedList<Integer>(new DeleteAll<>());
        var testList = List.of(5, 7, 4, 6, 8, 2);
        for (Integer item : List.of(5, 3, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(3).asList());
    }

    @Test
    void testDeleteAll_Occurrences_first() {
        var list = new UnsortedLinkedList<Integer>(new DeleteAll<>());
        var testList = List.of(7, 4, 6, 3, 8, 2);
        for (Integer item : List.of(5, 5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(5).asList());
    }

    @Test
    void testDeleteAll_Occurrences_last() {
        var list = new UnsortedLinkedList<Integer>(new DeleteAll<>());
        var testList = List.of(5, 7, 4, 6, 3, 8);
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(2).asList());
    }

    @Test
    void testDeleteAll_Occurrences_empty() {
        var list = new UnsortedLinkedList<Integer>(new DeleteAll<>());
        var testList = Collections.emptyList();
        for (Integer item : List.of(2, 2)) {
            list.insertLast(item);
        }
        assertEquals(testList, list.remove(2).asList());
    }

    @Test
    void testDoWhen() {
        var list = new UnsortedLinkedList<Integer>();
        for (Integer item : List.of(5, 7, 4, 6, 3, 8, 2)) {
            list.insertLast(item);
        }
        final var testList = new UnsortedLinkedList<Integer>();
        list.doWhen(testList::insert, item -> item.compareTo(6) < 0);
        assertEquals(List.of(5, 4, 3, 2), testList.asList());
    }
}
