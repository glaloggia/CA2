package Tests;

import Code.GenericArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    GenericArrayList<Integer> someAL = new GenericArrayList<>();

    @BeforeEach
    void setUp() {
        someAL.add(1);
        someAL.add(2);
        someAL.add(3);
        someAL.add(4);
        someAL.add(5);
    }

    @Test
    @DisplayName("Add test, checking the empty property")
    void add1() {
        GenericArrayList<Integer> auxList = new GenericArrayList<>();
        auxList.add(1);
        assertFalse(auxList.isEmpty());
    }

    @Test
    @DisplayName("Add Test, consulting the element")
    void add2() {
        GenericArrayList<Integer> auxList = new GenericArrayList<>();
        auxList.add(1);
        assertEquals(1,auxList.get(0));
    }

    @Test
    void set() {
        someAL.set(2,10);
        assertEquals(10,someAL.get(2));
    }

    @Test
    void get() {
        assertEquals(1,someAL.get(0));
    }

    @Test
    void remove() {
        assertEquals(1,someAL.remove(0));
    }

    @Test
    @DisplayName("Contains Positive Case")
    void contains() {
        assertTrue(someAL.contains(1));
    }
@Test
    @DisplayName("Contains Negative Case")
    void contains2() {
        assertFalse(someAL.contains(11));
    }

    @Test
    void iterator() {
        System.out.println("");
        System.out.println("Iterator Test in ArrayList");
        for(Iterator<Integer> iterator = someAL.iterator(); iterator.hasNext(); ){
            int currElement = iterator.next();
            System.out.print(currElement + " ");
        }
    }

    @Test
    void isEmpty() {
        GenericArrayList<Integer> auxList =new GenericArrayList<>();
        assertTrue(auxList.isEmpty());

    }

    @Test
    void size() {
        someAL.remove(0);
        assertEquals(4,someAL.size());
    }
}