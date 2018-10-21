import static org.junit.Assert.*;



import org.junit.Test;

public class DAGTest {

	//recycled 2nd year programming work

	@Test
	public void testForDirectedGraph(){
		DAG test = new DAG(10);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		
		assertEquals("", 1, test.indegree(4));
		assertEquals("", 2, test.outdegree(4));
		assertEquals("", 5, test.E());
		assertEquals("", 10, test.V());
		String answer = "[5, 6]";
		assertEquals("",answer, test.adj(4).toString());
	}

	@Test
	public void testAddEdge(){

		DAG testX = new DAG(5);

		testX.addEdge(0, 1);

		//Doesn't add an edge
		testX.addEdge(-2, -5);	

		assertEquals("Testing edge count is 1", 1, testX.E());
		testX.addEdge(1, 2);

		assertEquals("Testing edge count is 2", 2, testX.E());
	}

	@Test
	public void testinDegree(){
		DAG testY = new DAG(5);

		assertEquals("", -1, testY.indegree(-3));
	}

	@Test
	public void testOutDegree(){

		DAG testZ = new DAG(5);
		assertEquals("", -1, testZ.outdegree(8));	
	}

	
}