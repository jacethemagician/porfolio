// Jace Yang, jaceyang@brandeis.edu

/**
 * HashMap class
 */
public class HashMap {

	private static final int INITIAL_TABLE_SIZE = 9;
	private int tableSize;
	private int nonZeroElements;
	private Entry[] table;

	/**
	 * Constructor of HashMap, which initializes the table
	 * Runtime: O(N)
	 */
	public HashMap() {
		this.tableSize = INITIAL_TABLE_SIZE;
		this.table = new Entry[tableSize];
		
		for (int i = 0; i < tableSize; i++) {
			this.table[i] = null;
		}
		
		nonZeroElements = 0; // Keeps track of how many non null elements there are in the table
	}
	
	/**
	 * Sets an Entry in the table
	 * Runtime: O(N)
	 * @param key
	 * @param value
	 */
	public void set(GraphNode key, int value) {
		nonZeroElements++;
		
		double loadFactor = nonZeroElements * 1.0 / tableSize;
		if (loadFactor > 0.5) {
			rehash();
		}
		
		HashMap.set(table, tableSize, key, value);
	}

	/**
	 * Sets an Entry in the table
	 * Runtime: O(N)
	 * @param table
	 * @param tableSize
	 * @param key
	 * @param value
	 */
	private static void set(Entry[] table, int tableSize, GraphNode key, int value) {
		int hashIndex = HashMap.hash(tableSize, key, 0);
		
		Entry entry = table[hashIndex];
		// Check if there is anything at the position
		if (entry == null) { 
			// There is no element here so just insert into table
			table[hashIndex] = new Entry(key, value);
		} else {
			// There is collision so loop until find an empty spot
			for (int i=0; i < tableSize; i++) {
				hashIndex = HashMap.hash(tableSize, key, i);
				Entry e = table[hashIndex];
				
				if (e != null) {
					if (entry.getKey() == key) { 
						// Key exists, so update value
						entry.setValue(value);
						return;
					}
				} else {
					// Key does not exist so add it
					table[hashIndex] = new Entry(key, value);
					return;
				}
			}
		}
	}
	
	/**
	 * Rehashing the table
	 * Runtime: O(N)
	 */
	private void rehash() {
		int oldHashSize = tableSize;
		tableSize *= 2;
		Entry[] newTable = new Entry[tableSize];
		
		// Move the Entry from old to new table
		for (int i=0; i < oldHashSize; i++) {
			Entry e = table[i];
			if (e != null) {
				HashMap.set(newTable, tableSize, e.getKey(), e.getValue());
			}
		}
		
		table = newTable;
	}
	
	/**
	 * Hashing function that utilizes double hashing
	 * Runtime: O(1)
	 * @param tableSize
	 * @param key
	 * @param i
	 * @return
	 */
	private static int hash(int tableSize, GraphNode key, int i) {
		int hash = ((key.getId().hashCode() % tableSize) + (i * (7 - key.getId().hashCode() % 7))) % tableSize;
		if (hash < 0) {
			// modulo operation returned negative number so add tableSize
			hash += tableSize;
		}
		return hash;
	}

	/**
	 * Returns the value of Entry
	 * Runtime: O(N)
	 * @param g
	 * @return
	 * @throws Exception
	 */
	public int getValue(GraphNode g) throws Exception {
		Entry e = this.getEntry(g);
		if (e != null) {
			return e.getValue();
		}
		
		throw new Exception();
	}

	/**
	 * Returns if there is a key
	 * Runtime: O(N)
	 * @param g
	 * @return true if key exists, false otherwise
	 */
	public boolean hasKey(GraphNode g) {
		return this.getEntry(g) != null;
	}
	
	/**
	 * Returns the Entry corresponding to the GraphNode g
	 * Runtime: O(N)
	 * @param g
	 * @return Entry
	 */
	private Entry getEntry(GraphNode g) {
		for (int i=0; i < tableSize; i++) {
			if (table[i] != null && table[i].getKey() == g) {
				return table[i];
			}
		}
		
		return null;
	}
	
	/**
	 * Returns string representation of the HashMap
	 * Runtime: O(N)
	 */
	public String toString() {
		String s = "";
		for (int i=0; i < tableSize; i++) {
			if (table[i] != null) {
				s += table[i].toString() + "\n";
			}
		}
		return s;
	}
}
