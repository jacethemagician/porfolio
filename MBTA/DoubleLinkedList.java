//Jace Yang
//magician@brandeis.edu
//Feb 17, 2019
//PA#1
/* This class represents the fundamental data structure: Double Linked List*/
/* Known Bugs: explain bugs/null pointers/etc. */

public class DoubleLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length;
    
    public DoubleLinkedList (){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    //return head node
    public Node<T> getHead(){
        return this.head;
    }
    
    //return tail node
    public Node<T> getTail(){
        return this.tail;
    }
    
    //insert to end of the list
    public Node<T> insert(T key) {
        Node<T> newNode = new Node<T>(key, null, null);
        
        tail.setNext(newNode);
        newNode.setPrev(tail);
        
        //make the added node the tail node
        tail = newNode;
        //increment length of the Double Linked List by 1
        length++;
        
        return tail;
    }
    
    //delete the first instance of the given key
    public void delete(T key) {
        Node<T> currNode = head;
        while (currNode != null) {
            // case 1: key is found
            if (currNode.getElement().equals(key)) {
                //found in the beginning
                if (currNode.getPrev() == null) {
                    head = currNode.getNext();
                } else if (currNode.getNext() == null) { //found in the end
                    tail = currNode.getPrev();
                    currNode.getPrev().setNext() = null;
                } else { //found in the middle
                    currNode.getPrev().setNext() = currNode.getNext();
                    currNode.getNext().setPrev() = currNode.getPrev();
                }
                //reduce length by 1
                length--;
            } else {
                currNode = currNode.getNext();
            }
        }
    }
    
    //return the element with the key
    public T get(T key){
        Node<T> currNode = head;
        while (currNode != null) {
            if (currNode.getElement().compareTo(key)) {
                return currNode.getElement();
            }
            currNode = currNode.getNext();
        }
    }
    
    //return the length
    public int length() {
        return this.length;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        int currPos = 0;
        Node<T> currNode = head;
        while (currPos <= length) {
            s.append(currNode.getElement() + " ");
            currNode = currNode.next;
            currPos++;
        }
        
        return s.toString();
    }
    
}
