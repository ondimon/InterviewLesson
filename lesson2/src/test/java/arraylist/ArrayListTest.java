package arraylist;

import linkedlist.TwoDirectionalList;
import list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private List<Integer> arrayList;

    @BeforeEach
    void BeforeEach() {
        arrayList = new ArrayList<>();
    }

    @Test
    void add() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(4, arrayList.size());
    }

    @Test
    void get() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(2, arrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class,  ()-> arrayList.get(4));

    }

    @Test
    void size() {
        assertEquals(0, arrayList.size());
        arrayList.add(1);
        assertEquals(1, arrayList.size());
    }

    @Test
    void remove() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.remove(2);
        assertEquals(3, arrayList.size());
        assertEquals(1, arrayList.get(0));
        assertEquals(3, arrayList.get(1));
        assertEquals(4, arrayList.get(2));
        assertThrows(IndexOutOfBoundsException.class,  ()-> arrayList.get(3));
    }

    @Test
    void indexOf() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(0, arrayList.indexOf(1));
        assertEquals(3, arrayList.indexOf(4));
    }
}