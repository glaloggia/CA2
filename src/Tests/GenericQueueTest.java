package Tests;

import Code.GenericQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {
    GenericQueue<Integer> oneQueue;
    @BeforeEach
    void setUp() {
        oneQueue = new GenericQueue();

    }

    @Test
    void enqueue() {
        oneQueue.enqueue(1);
        assertEquals(1,oneQueue.first());
        assertFalse(oneQueue.empty());
    }

    @Test
    void dequeue() {
        oneQueue.enqueue(1);
        oneQueue.dequeue();
        assertTrue(oneQueue.empty());
    }

    @Test
    void first() {
        oneQueue.enqueue(1);
        assertEquals(1,oneQueue.first());
        assertFalse(oneQueue.empty());
    }

    @Test
    void iterator() {
        System.out.println("");
        System.out.println("Iterator Test in GenericQueue");
        oneQueue.enqueue(1);
        oneQueue.enqueue(2);
        oneQueue.enqueue(3);
        oneQueue.enqueue(4);
        oneQueue.enqueue(5);
        for(Iterator<Integer> iterator = oneQueue.iterator(); iterator.hasNext(); ){
            int currElement = iterator.next();
            System.out.print(currElement + " ");
        }
    }

    @Test
    void empty() {
        assertTrue(oneQueue.empty());
    }
}