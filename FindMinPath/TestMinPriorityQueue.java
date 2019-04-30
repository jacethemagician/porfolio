// Jace Yang, jaceyang@brandeis.edu

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class TestMinPriorityQueue {
	
	@Test
	public void setInsert() throws Exception {
	    MinPriorityQueue q = new MinPriorityQueue();
	    GraphNode g1 = new GraphNode("A", false);
	    g1.priority = 100;
	    q.insert(g1);
	    
	    GraphNode g2 = new GraphNode("B", false);
	    g2.priority = 32;
	    q.insert(g2);
	    
	    GraphNode g3 = new GraphNode("C", false);
	    g3.priority = 22;
	    q.insert(g3);
	    
	    GraphNode g4 = new GraphNode("D", false);
	    g4.priority = 10000;
	    q.insert(g4);
	    
	    assertEquals("C", q.pullHighestPriorityElement().getId());
	    assertEquals("B", q.pullHighestPriorityElement().getId());
	    assertEquals("A", q.pullHighestPriorityElement().getId());
	    assertEquals("D", q.pullHighestPriorityElement().getId());
	}
	
	@Test
	public void setInsertRandom() throws Exception {
		ArrayList<Integer> a = new ArrayList<Integer>();
		MinPriorityQueue q = new MinPriorityQueue();
		Random rand = new Random();
		
		for (int i=0; i < 5; i++) {
			int r = rand.nextInt(50);
			GraphNode g = new GraphNode(Integer.toString(i), false);
		    g.priority = r;
		    q.insert(g);
		    a.add(r);
		}
		
		Collections.sort(a);
		
		for (int i=0; i < 5; i++) {
			int r = a.get(i);
			GraphNode g = q.pullHighestPriorityElement();
			assertEquals(r, g.priority);
		}
	    
	}
	
	@Test
	public void setInsertRegressionFix() throws Exception {
		MinPriorityQueue q = new MinPriorityQueue();
		
		GraphNode g0 = new GraphNode(Integer.toString(0), false);
		GraphNode g1 = new GraphNode(Integer.toString(1), false);
		GraphNode g2 = new GraphNode(Integer.toString(2), false);
		GraphNode g3 = new GraphNode(Integer.toString(3), false);
		GraphNode g4 = new GraphNode(Integer.toString(4), false);
		
		g0.priority = 37;
		g1.priority = 11;
		g2.priority = 26;
		g3.priority = 24;
		g4.priority = 24;
		
		q.insert(g0);
		q.insert(g1);
		q.insert(g2);
		q.insert(g3);
		q.insert(g4);
		
		assertEquals(11, q.pullHighestPriorityElement().priority);
		assertEquals(24, q.pullHighestPriorityElement().priority);
		assertEquals(24, q.pullHighestPriorityElement().priority);
		assertEquals(26, q.pullHighestPriorityElement().priority);
		assertEquals(37, q.pullHighestPriorityElement().priority);
	    
	}
}
