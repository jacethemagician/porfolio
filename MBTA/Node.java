//Jace Yang
//magician@brandeis.edu
//Feb 17, 2019
//PA#1
/* This class represents the fundamental data structure: Node*/
/* Known Bugs: explain bugs/null pointers/etc. */

public class Node<T> {
    
    T element;
    Node<T> next;
    Node<T> prev;
    
    //default, creates null node
    public Node() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }
    
    public Node(T element, Node<T> next, Node<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
    
    //set the element
    public void setElement(T element) {
        this.element = element;
    }
    
    //set the next node
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    //set the previous node
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    //return the element at the node
    public T getElement() {
        return this.element;
    }
    
    //return the next node
    public Node<T> getNext() {
        return this.next;
    }
    
    //return the previous node
    public Node<T> getPrev(){
        return this.prev;
    }
    
    //return the String representation of the element
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.element);
        return s.toString();
    }
    
}
