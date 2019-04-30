// Jace Yang, jaceyang@brandeis.edu

import static org.junit.Assert.*;
import org.junit.Test;

public class TestHashMap {
	
	@Test
	public void setTest() {
	    HashMap map = new HashMap();
	    GraphNode g = new GraphNode(Integer.toString(20), true);
	    map.set(g, 20);
	    
	    for (int i=0; i < 20; i++) {
	    		map.set(new GraphNode(Integer.toString(i), true), i);
	    }
	    
	    map.set(g, 40);
	   
	}
}
