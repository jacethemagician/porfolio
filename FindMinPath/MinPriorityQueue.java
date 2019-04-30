// Jace Yang, jaceyang@brandeis.edu

/**
 * MinPriorirtyQueue class
 */
public class MinPriorityQueue {
	
	private static final int INITIAL_QUEUE_SIZE = 9;
	private static final int HEAPIFY_UP = 0;
	private static final int HEAPIFY_DOWN = 1;
	private GraphNode[] minPriorityQueue;
	private HashMap nodeToHeapIndex;
	private int numItems;

	/**
	 * Constructor for MinPriorityQueue, which initializes the queue and the HashMap
	 * Runtime: O(1)
	 */
	public MinPriorityQueue() {
		minPriorityQueue = new GraphNode[INITIAL_QUEUE_SIZE];
		numItems = 0;
		nodeToHeapIndex = new HashMap();
	}
	
	/**
	 * Inserts a GraphNode to the queue
	 * Runtime: O(N)
	 * @param g
	 */
	public void insert(GraphNode g) {
		if (numItems == minPriorityQueue.length - 1) {
			resize();
		}
		
		minPriorityQueue[numItems] = g;
		
		nodeToHeapIndex.set(g, numItems);
		
		// Restore heap property by heapifying the inserted element
		rebalance(numItems, HEAPIFY_UP);
		
		numItems += 1;
	}
	
	/**
	 * Resizing the queue since it is filled
	 * Runtime: O(N)
	 */
	private void resize() {
		GraphNode[] newQueue = new GraphNode[minPriorityQueue.length * 2];
		for (int i=0; i < numItems; i++) {
			newQueue[i] = minPriorityQueue[i];
		}
		minPriorityQueue = newQueue;
	}
	
	/**
	 * Rebalance to restore heap property
	 * Runtime: O(logN)
	 * @param position
	 * @param heapifyIndex
	 */
	public void rebalance(int position, int heapifyIndex) {
		if (heapifyIndex == HEAPIFY_UP) {
			heapifyUp(position);
		} else if (heapifyIndex == HEAPIFY_DOWN) {
			heapifyDown(position);
		}	
	}
	
	/**
	 * Heapify up to restore heap property
	 * Runtime: O(logN)
	 * @param position
	 */
	private void heapifyUp(int position) {
		while (position >= 1 && minPriorityQueue[position].priority < minPriorityQueue[position / 2].priority) {
			swap(position, position / 2);
			position /= 2; // Position of parent
		}
	}
	
	/**
	 * Swaps the element at position1 and position2 and updates index in hash table
	 * Runtime: O(1)
	 * @param position1
	 * @param position2
	 */
	private void swap(int position1, int position2) {
		GraphNode temp = minPriorityQueue[position1];
		minPriorityQueue[position1] = minPriorityQueue[position2];
		minPriorityQueue[position2] = temp;
		
		if (minPriorityQueue[position1] != null) {
			nodeToHeapIndex.set(minPriorityQueue[position1], position1); // Set/Change position1
		}
		
		if (minPriorityQueue[position2] != null) {
			nodeToHeapIndex.set(minPriorityQueue[position2], position2); // Set/Change position2
		}
		
	}
	
	/**
	 * Takes out the highest priority element from the queue
	 * Runtime: O(logN)
	 * @return GraphNode
	 * @throws Exception
	 */
	public GraphNode pullHighestPriorityElement() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		
		GraphNode min = minPriorityQueue[0];
		minPriorityQueue[0] = null;
		swap(0, --numItems);
		rebalance(0, HEAPIFY_DOWN);
		
		if (min == null) {
			throw new Exception();
		}
		
		return min;
	}
	
	/**
	 * Heapify down to restore heap property
	 * Runtime: O(logN)
	 * @param position
	 */
	private void heapifyDown(int position) {
		int left = position * 2;
		int right = position * 2 + 1;
		int smallest;
		
		if (left < numItems && minPriorityQueue[left].priority < minPriorityQueue[position].priority) {
			smallest = left;
		} else {
			smallest = position;
		}
		
		if (right < numItems && minPriorityQueue[right].priority < minPriorityQueue[smallest].priority) {
			smallest = right;
		} 

		if (smallest != position) {
			swap(position, smallest);
			heapifyDown(smallest);
		}
	}
	
	/**
	 * Checks if queue is empty
	 * Runtime: O(1)
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	/**
	 * Checks if GraphNode is in queue
	 * Runtime: O(N)
	 * @param g
	 * @return true if GraphNode exists, false otherwise
	 */
	public boolean contains(GraphNode g) {
		return nodeToHeapIndex.hasKey(g);
	}
	
	/**
	 * Returns string representation of queue
	 * Runtime: O(N)
	 */
	public String toString() {
		String s = "";
		for (int i=0; i < minPriorityQueue.length; i++) {
			if (minPriorityQueue[i] == null) {
				s += i + ": " + "null\n";
			} else {
				try {
					s += i + ": " + minPriorityQueue[i].getId() + ", " + minPriorityQueue[i].priority + "\n";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return s;
	}
}
