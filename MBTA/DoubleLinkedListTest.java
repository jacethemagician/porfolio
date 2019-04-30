package PA1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Class for JUnit test
 *
 */
public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> L = new DoubleLinkedList<>();

    /**
     *
     */
    @Test
    void getHead() {
        assertNull(L.getHead());
        L.insert(1);
        L.insert(2);
        assertEquals(1, (int) L.getHead().getElement());
    }

    @Test
    void getTail() {
        assertNull(L.getTail());
        L.insert(1);
        L.insert(2);
        assertEquals(2, (int) L.getTail().getElement());
    }



    @Test
    void insert() {

        L.insert(1);
        assertEquals(1, (int) L.getHead().getElement());
        L.insert(2);
        L.insert(3);
        L.insert(4);
        assertEquals(4, (int) L.getTail().getElement());
        assertEquals(4, L.length());

    }

    @Test
    void delete() {

        L.insert(1);
        L.insert(2);
        L.insert(3);
        L.insert(4);
        assertEquals(4, L.length());
        L.delete(4);
        assertEquals(3, L.length());
        assertEquals("1 2 3 ", L.toString());
    }

    @Test
    void get() {
        L.insert(1);
        L.insert(2);
        L.insert(3);
        L.insert(4);
        assertEquals(3, (int) L.get(3));
    }

    @Test
    void length() {
        assertEquals(0, L.length());
        L.insert(1);
        L.insert(2);
        L.insert(3);
        assertEquals(3, L.length());
    }

    @Test
    void TESTtoString() {
        assertNull(L.toString());
        L.insert(1);
        L.insert(2);
        L.insert(3);
        L.insert(4);
        assertEquals("1 2 3 4 ", L.toString());
    }
}