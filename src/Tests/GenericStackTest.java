package Tests;

import Code.GenericStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    GenericStack<Integer> oneStack;
    @BeforeEach
    void setUp() {
        oneStack = new GenericStack<>();
    }

    @Test
    void push() {
        oneStack.push(1);
        assertEquals(1,oneStack.pop());
    }

    @Test
    void pop() {
        oneStack.push(1);
        oneStack.push(2);
        assertEquals(2,oneStack.pop());
    }

    @Test
    void peek() {
        oneStack.push(0);
        assertEquals(0,oneStack.peek());
        assertEquals(0,oneStack.pop());
    }

    @Test
    void iterator() {
        System.out.println("");
        System.out.println("Iterator Test in GenericStack");
        oneStack.push(1);
        oneStack.push(2);
        oneStack.push(3);
        oneStack.push(4);
        oneStack.push(5);
        for(Iterator<Integer> iterator = oneStack.iterator(); iterator.hasNext(); ){
            int currElement = iterator.next();
            System.out.print(currElement + " ");
        }
    }

    @Test
    void empty() {
        oneStack.pop();
        oneStack.empty();
    }
}