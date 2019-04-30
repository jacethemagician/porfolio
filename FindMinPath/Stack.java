// Jace Yang, jaceyang@brandeis.edu

/**
 * Stack class
 */
public class Stack {
	private static final int SIZE = 10000;
	int top; // Keeps track of current location in array
	String[] stack;
	
	/**
	 * Constructor for stack, which initializes the array
	 * Runtime: O(1)
	 */
	public Stack() {
		stack = new String[SIZE];
		top = -1;
	}
	
	/**
	 * Push to stack
	 * Runtime: O(1)
	 * @param s
	 */
	public void push(String s) {
		if (top >= SIZE) {
			// Stack overflow
			return; 
		}

		top++;
		stack[top] = s;
	}
	
	/**
	 * Pop from stack
	 * Runtime: O(1)
	 * @return String
	 */
	public String pop() {
		if (top < 0) {
			// Stack underflow
			return null;
		}

		String s = stack[top];
		top--;
		return s;
	}
	
	/**
	 * Checks if stack is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return top < 0;
	}
}
