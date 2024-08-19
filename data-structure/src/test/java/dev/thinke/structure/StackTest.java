package dev.thinke.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    void testPush_pop() {
        var list = new UnsortedLinkedList<Integer>();
        var stack = new Stack<>(list);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop().get());
        assertEquals(2, stack.pop().get());
        assertEquals(1, stack.pop().get());
        assertEquals(0, list.size());
    }
}
