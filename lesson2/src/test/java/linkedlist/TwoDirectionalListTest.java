package linkedlist;

import list.DirectionalList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDirectionalListTest {
    private DirectionalList<String> twoDirectionalList;

    @BeforeEach
    void BeforeEach() {
        twoDirectionalList = new TwoDirectionalList<>();
    }

    @Test
    void add() {
        assertEquals(0, twoDirectionalList.size());
        twoDirectionalList.add("test");
        assertEquals(1, twoDirectionalList.size());
    }

    @Test
    void remove() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        twoDirectionalList.add("test 3");
        twoDirectionalList.remove("test 3");

        assertEquals(2, twoDirectionalList.size());
        assertEquals("test 1", twoDirectionalList.getFirst());
        assertEquals("test 2", twoDirectionalList.getLast());
    }

    @Test
    void getFirst() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        assertEquals("test 1", twoDirectionalList.getFirst());
    }

    @Test
    void getLast() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        assertEquals("test 2", twoDirectionalList.getLast());
    }

    @Test
    void size() {
        assertEquals(0, twoDirectionalList.size());
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        assertEquals(2, twoDirectionalList.size());
    }

    @Test
    void testToString() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        assertEquals("[test 1, test 2]", twoDirectionalList.toString());
    }

    @Test
    void get() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        twoDirectionalList.add("test 3");
        twoDirectionalList.add("test 4");
        twoDirectionalList.add("test 5");

        assertEquals("test 4", twoDirectionalList.get(3));
        assertEquals("test 2", twoDirectionalList.get(1));
        assertThrows(IndexOutOfBoundsException.class,  ()->{twoDirectionalList.get(5);});
    }


    @Test
    void indexOf() {
        twoDirectionalList.add("test 1");
        twoDirectionalList.add("test 2");
        twoDirectionalList.add("test 3");
        assertEquals(0, twoDirectionalList.indexOf("test 1"));
        assertEquals(2, twoDirectionalList.indexOf("test 3"));
    }
}