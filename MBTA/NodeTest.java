//Jace Yang
//magician@brandeis.edu
//Feb 17, 2019
//PA#1
/* This class tests the Node class */
/* Known Bugs: explain bugs/null pointers/etc. */


package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {
    
    Node<T> n1;
    
    @Test
    void initTest() {
        n1 = new Node();
        assertEquals(null, n1.getElement());
        assertEquals(null, n1.getNext());
        assertEquals(null, n1.getPrev());
        
        
    }
