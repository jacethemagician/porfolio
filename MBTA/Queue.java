//Jace Yang, jaceyang@brandeis.edu

public class Queue<T> {

	T[] q;
	int head;
	int tail;
	int length;    // length of the current element
	int size;		// capacity
	
	/**
	 * Constructor for queue with size in parameter
	 * @param size
	 * O(1)
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size){
		q = (T[]) new Object[size];
		this.size = size;
		length = 0;
		head = 0;
		tail = 0;
	}

	/**
	 * enqueue method to add element T into the queue
	 * @param element T that need to be enqueued
	 * @throws Exception
	 * O(1)
	 */
	public void enqueue(T element) throws Exception {
	    if (length >= size){
	        throw new Exception("Queue overflow");
        }
	    else{
			q[tail] = element;
			length ++;
			if (tail == size - 1){
				tail = 0;
			} else{
				tail++;
			}
		}
	}

	/**
	 * dequeue method to delete element from the queue
	 * @return the element that is deleted
	 * @throws Exception
	 * O(1)
	 */
	public T dequeue() throws Exception{
		if(!isEmpty()) {
			T element = q[head];
			if(head == size - 1){
				head = 0;
			} else{
					head++;
				}
				length --;
			return element;
		} else {
			throw new Exception("Queue underflow");
		}
	}

	/**
	 * peek method
	 * @return the head element without deleting it
	 * O(1)
	 */
	public T peek() {
		if(!isEmpty()) {
			return q[head];
		} else {
			return null;
		}
	}

	/**
	 * Length method
	 * @return return the length
	 * O(1)
	 */
	public int length() {
		if(!isEmpty()) {
			return length;
		} else {
			return 0;	
		}
	}

	/**
	 * isEmpty method
	 * @return a boolean if the queue is empty
	 * O(1)
	 */
	public boolean isEmpty() {
		return tail == head;
	}

	/**
	 * toString method that override
	 * @return a string that we need
	 * O(n)
	 */
	public String toString() {
		String text = "";
		int curr = head;
		if(!this.isEmpty()) {
			while (curr != tail){
				text += q[curr] + " ";
				curr++;
			}
			return text;
		} else {
			return null;	
		}
	}
}
