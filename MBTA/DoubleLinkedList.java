
//Zhaoyang Liu
//zliu21@brandeis.edu
//02-06-2019
//PA1
/* This class helps to implement Double Linked List */
/* Known Bugs: none */

package PA1;
public class DoubleLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int length;

	/**
	 * DoubleLinkedList method constructor
	 * O(1)
	 */
	public DoubleLinkedList (){
		head = null;
		tail = null;
		length = 0;
	}

	/**
	 * getHead method return the point of the head
	 * @return Node with type T, a pointer of the head
	 * O(1)
	 */
	public Node<T> getHead(){
			return head;
	}

	/**
	 * getTail method return the point of the tail
	 * @return Node with type T, a pointer of the tail
	 * O(1)
	 */
	public Node<T> getTail(){
			return tail;
	}

	 /**
     * insert method to insert key to the end of the list
     * @param key with generic type
     * @return the inserted newNode
     */
	public Node<T> insert(T key) {
		Node<T> newNode = new Node(key, null, null);
        if (head == null) {
            head = newNode;
            head.prev = null;
        }
        else{
            Node<T> lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            newNode.prev = lastNode;
            newNode.next = null;
        }
		tail = newNode;
		length++;
		return tail;
	}
	
	/**
	 * Function to delete the given key from the list
	 * @return key
	 * The running time is O(n)
	 */
	public void delete(T key) {
		Node<T> position = head;
		while (position != null) {
			if (position.getElement().equals(key)) {
				if (position.prev != null){
					position.prev.next = position.next;
					position.next = position.prev;
					length --;
					return;
				} else{
					head = position.next;
					length --;
				}
			}
			position = position.next;
		}
	}
	
	/**
	 * Function to get the key from current Node
	 * @return key
	 * The running time is O(1)
	 */
	public T get(T key){
		if (length != 0) {
			Node<T> curr = head;
			while (curr != null) {
				if (curr.getElement().equals(key)) {
					return curr.getElement();
				}
				curr = curr.next;
			}
			return null;
		}
		return null;
	}
	
	/**
	 * returns the length of the linked list
	 * @return int length
	 * O(1)
	 */
	public int length() {
		return length;
	}

	/**
	 * return the String as needed
	 * @return String with information
	 * O(n)
	 */
	public String toString() {
	    String text = "";
		if (length == 0) {
			return null;			
		}
		else{
		    Node<T> curr = head;
		    while (curr != null){
		        text = text + curr.getElement().toString() + " ";
		        curr = curr.next;
            }
		    return text;
        }
	}
	
}
