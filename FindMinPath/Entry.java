// Jace Yang, jaceyang@brandeis.edu

/**
 * Entry class that stores GraphNode as key and the index as value
 */
public class Entry {

	private GraphNode key;
	private int value;
	
	/**
	 * Constructor for Entry
	 * Runtime: O(1)
	 * @param key
	 * @param value
	 */
	public Entry(GraphNode key, int value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Runtime: O(1)
	 * @return key
	 */
	public GraphNode getKey() {
		return key;
	}
	
	/**
	 * Runtime: O(1)
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the key
	 * Runtime: O(1)
	 * @param key
	 */
	public void setKey(GraphNode key) {
		this.key = key;
	}
	
	/**
	 * Set the value
	 * Runtime: O(1)
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Returns string representation
	 * Runtime: O(1)
	 */
	public String toString() {
		return "key: " + key + ", value: " + value;
 	}
}
