//Jace Yang, jaceyang@brandeis.edu

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<Integer> q = new Queue<>(10);

    @Test
    void enqueue() throws Exception {
        assertNull(q.peek());
        assertEquals(10, q.size);
        assertEquals(0, q.length);
        q.enqueue(10);
        assertEquals(1, q.length);
        assertEquals(10, (int) q.peek());
    }

    @Test
    void dequeue() throws Exception {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, (int) q.dequeue());
        assertEquals(2, (int) q.dequeue());
    }

    @Test
    void peek() throws Exception {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, (int) q.peek());
    }

    @Test
    void length() throws Exception {
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(2, q.length);
        q.enqueue(3);
        assertEquals(3, q.length);
    }

    @Test
    void isEmpty() throws Exception {
        assertTrue(q.isEmpty());
        q.enqueue(1);
        assertFalse(q.isEmpty());
    }

    @Test
    void TestToString() throws Exception {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertEquals("1 2 3 ",q.toString());
    }
}