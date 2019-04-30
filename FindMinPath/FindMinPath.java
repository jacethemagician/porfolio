// Jace Yang, jaceyang@brandeis.edu

import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FindMinPath class
 * Finds the minimum path between a given start and goal
 */
public class FindMinPath {
	private MinPriorityQueue minQ;
	private GraphWrapper gw;
	private static final String NORTH = "North";
	private static final String EAST = "East";
	private static final String SOUTH = "South";
	private static final String WEST = "West";

	public static void main(String[] args) throws Exception {
		FindMinPath findMinPath = new FindMinPath();
	}

	/**
	 * Constructor for FindMinPath
	 * Runtime: O(N)
	 * @throws Exception
	 */
	public FindMinPath() throws Exception {
		minQ = new MinPriorityQueue();
		gw = new GraphWrapper(false);

		GraphNode goal = findShortestPath(gw);

		outputPath(goal);
	}

	/**
	 * Finds the goal node, which knows the shortest path from goal to start
	 * Runtime: O(N)
	 * @param gw
	 * @return goal
	 * @throws Exception
	 */
	private GraphNode findShortestPath(GraphWrapper gw) throws Exception {
		GraphNode home = gw.getHome();
		home.priority = 0;
		minQ.insert(home);

		GraphNode goal = null;

		while (!minQ.isEmpty()) {
			GraphNode curr = minQ.pullHighestPriorityElement();
			
			if (curr.isGoalNode()) {
				goal = curr;
			} else {
				// Check each neighbor
				searchNeighbor(curr, curr.getNorth(), curr.getNorthWeight(), SOUTH);
				searchNeighbor(curr, curr.getEast(), curr.getEastWeight(), WEST);
				searchNeighbor(curr, curr.getSouth(), curr.getSouthWeight(), NORTH);
				searchNeighbor(curr, curr.getWest(), curr.getWestWeight(), EAST);
			}

		}

		return goal;
	}

	/**
	 * Checks the neighbor and see if there is a shorter path
	 * Runtime: O(1)
	 * @param curr
	 * @param next
	 * @param weight
	 * @param previousDirection
	 */
	private void searchNeighbor(GraphNode curr, GraphNode next, int weight, String previousDirection) {
		if (next == null) {
			return;
		}

		int x = curr.priority + weight;

		if (!minQ.contains(next) || x < next.priority) {
			next.priority = x;
			next.previousNode = curr;
			next.previousDirection = previousDirection;
			minQ.insert(next);
		}
	}

	/**
	 * Outputs the shortest path from start to goal in "answer.txt"
	 * Runtime: O(N)
	 * @param goal
	 * @throws IOException
	 */
	private void outputPath(GraphNode goal) throws IOException {
		if (goal == null) {
			System.out.println("No path");
			return;
		}
		
		Stack s = new Stack();

		// Checks path backwards (from goal to start)
		while (goal.previousNode != null) {
			s.push(goal.previousDirection);
			goal = goal.previousNode;
		}

		// Path from start to goal
		String output = "";
		while (!s.isEmpty()) {
			String temp = s.pop();
			if (temp.equals(NORTH)) {
				output += SOUTH + "\n";
			} else if (temp.equals(EAST)) {
				output += WEST + "\n";
			} else if (temp.equals(SOUTH)) {
				output += NORTH + "\n";
			} else if (temp.equals(WEST)) {
				output += EAST + "\n";
			}
		}

		System.out.println(output);
		
		// Writing to file
		BufferedWriter writer = new BufferedWriter(new FileWriter("answer.txt"));
		writer.write(output);
		writer.close();
	}
}
