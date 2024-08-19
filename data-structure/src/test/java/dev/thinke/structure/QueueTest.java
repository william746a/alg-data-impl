package dev.thinke.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    void testEnqueue_dequeue() {
        var list = new UnsortedLinkedList<Integer>();
        var queue = new Queue<Integer>(list);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().get());
        assertEquals(2, queue.dequeue().get());
        assertEquals(3, queue.dequeue().get());
        assertEquals(0, list.size());
    }
}
