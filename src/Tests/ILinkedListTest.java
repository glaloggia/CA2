package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import Code.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ILinkedListTest {

    ILinkedList<Integer> oneList = new ILinkedList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        oneList.add(1);
        oneList.add(2);
        oneList.add(3);
        oneList.add(4);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing adding one element the end")
    void add1() {
        oneList.add(10);
        Assertions.assertEquals(10,oneList.get(4));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing adding one element in a specific position")
    void add2() {
        oneList.add(3,2);
        Assertions.assertEquals(2,oneList.get(3));
    }

    @org.junit.jupiter.api.Test
    void set() {
        oneList.set(3,8);
        Assertions.assertEquals(8,oneList.get(3));
    }

    @org.junit.jupiter.api.Test
    void get() {
        int aux;
        aux = oneList.get(0);
        assertEquals(1,aux);
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(4,oneList.size());
    }

    @DisplayName("Remove an item from a position")
    @org.junit.jupiter.api.Test
    void remove1() {
        Assertions.assertEquals(1,oneList.remove(0));
    }

    @DisplayName("Remove an item by comparison")
    @org.junit.jupiter.api.Test
    void remove2() {
        int item = 2;
        assertTrue(oneList.remove(item)!=0);
    }
    @DisplayName("Remove an item by comparison using Parser")
    @org.junit.jupiter.api.Test
    void remove3() {
        int item = 2;
        assertTrue(oneList.remove(Integer.valueOf(item)));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ILinkedList<Integer> auxList = new ILinkedList<>();
        Assertions.assertTrue(auxList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("It contains")
    void contains1() {
        Assertions.assertTrue(oneList.contains(3));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("It doesn't contain")
    void contains2() {
        Assertions.assertFalse(oneList.contains(8));
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        System.out.println("");
        System.out.println("Iterator Test in LinkedList");
        for(Iterator<Integer> iterator = oneList.iterator(); iterator.hasNext(); ){
            int currElement = iterator.next();
            System.out.print(currElement + " ");
        }
    }
}