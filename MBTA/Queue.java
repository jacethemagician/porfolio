//Jace Yang
//magician@brandeis.edu
//Feb 17, 2019
//PA#1
/* This class represents the fundamental data structure: Queue*/
/* Known Bugs: explain bugs/null pointers/etc. */

public class Queue<T> {
    
    T[] q;
    int head;
    int tail;
    int length;
    int size;
    
    @SuppressWarnings("unchecked")
    public Queue(int size){
        this.size = size;
        this.q = (T[]) new Object[size];
        this.head = 0;
        this.tail = this.size - 1;
        this.length = 0;
        
    }
    
    //add an element to the tail
    public void enqueue(T element) {
        if (this.size == this.length) {
            System.out.println("Error: Queue full");
        } else {
            tail = (tail + 1) % size;
            q[tail] = element;
            
        }
    }
    
    //remove the head element
    public T dequeue() {
        if (length == 0) {
            System.out.println("Error: Queue empty");
        } else {
            T temp = q[head];
            head = (head + 1) % size;
            return temp;
        }
    }
    
    //return the head withough dequeueing
    public T peek() {
        if (length == 0) {
            System.out.println("Error: Queue empty");
            return null;
        } else {
            return q[head];
        }
    }
    
    //return the length
    public int length() {
        return length;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : q) {
            s.append(item + " ");
        }
        return s.toString();
    }
    
}
