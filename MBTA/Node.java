//Jace Yang, jaceyang@brandeis.edu

public class Node<T> {

	T element;
	Node<T> next;
	Node<T> prev;

	/**
	 * constructor method
	 * initiate variables
	 * O(1)
	 */
	public Node() {
		this.element = null;
		this.next = null;
		this.prev = null;
	}

	/**
	 * Constructor method
	 * @param element, type t
	 * @param next, node
	 * @param prev, node
	 * O(1)
	 */
	public Node (T element, Node<T> next, Node<T> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * setElement method
	 * @param element, t
	 * O(1)
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * getElement method
	 * @return the element of t type
	 * O(1)
	 */
	public T getElement() {
		return this.element;
	}

	/**
	 * mutator method that set the next node
	 * @param next node t
	 * O(1)
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * mutator method that set the previous node
	 * @param prev, node t
	 * O(1
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	/**
	 * assessor method that get the next node
	 * @return next node T
	 * O(1)
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * assessor method that get the previous node
	 * @return previous node t
	 * O(1)
	 */
	public Node<T> getPrev(){
		return prev;
	}

	/**
	 * tostring method
	 * @return the need string information about element
	 * O(1)
	 */
	public String toString() {
		return "" + element;
	}
	
}
