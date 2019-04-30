//Jace Yang, jaceyang@brandeis.edu

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node<Integer> N = new Node<>();
    Node<Integer> node1 = new Node<>();
    Node<Integer> node2 = new Node<>();
    Node<Integer> node3 = new Node<>(567, node1, node2);

    @Test
    void setElement() {
        assertNull(N.getElement());
        N.setElement(1);
        assertEquals(1, (int) N.getElement());
    }

    @Test
    void getElement() {
        assertNull(N.getElement());
        N.setElement(1);
        N.setElement(2);
        assertEquals(2, (int) N.getElement());
    }

    @Test
    void setNext() {
        node1.setNext(node2);
        assertEquals(node1.next, node2);
    }

    @Test
    void setPrev() {
        node2.setPrev(node1);
        assertEquals(node2.prev, node1);
    }

    @Test
    void getNext() {
        assertEquals(node1, node3.getNext());
    }

    @Test
    void getPrev() {
        assertEquals(node2, node3.getPrev());
    }

    @Test
    void TestToString() {
        N.setElement(123);
        assertEquals(""+123, N.toString());
    }
}