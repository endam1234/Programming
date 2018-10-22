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

	@Test(expected=Exception.class)

	public void exceptionTest(){
		//Can't make a directed graph with less than 0 vertices
		DAG testExc = new DAG(-5);
	}

	//Directed graph isnt necessarily a directed acyclic graph, so will need to ensure it is a DAG.
	@Test

	public void testsForCycle(){
		DAG cyclic = new DAG(20);
		cyclic.addEdge(0, 1);
		cyclic.addEdge(1, 2);
		cyclic.addEdge(2, 0);
		cyclic.findCycle(0);

		assertTrue(cyclic.hasCycle());
		DAG acyclic = new DAG(20);
		acyclic.addEdge(0, 1);
		acyclic.addEdge(1, 3);
		acyclic.addEdge(2, 4);

		acyclic.findCycle(0);
		assertFalse(acyclic.hasCycle());
	}

	@Test

	public void testLCA(){

		DAG lca = new DAG(10);
		//--------2---5----7--

		//---0--1-------6----8

		//--------3---4-------

		lca.addEdge(0, 1);
		lca.addEdge(1, 2);
		lca.addEdge(1, 3);
		lca.addEdge(2, 5);
		lca.addEdge(3, 4);
		lca.addEdge(4, 6);
		lca.addEdge(5, 6);
		lca.addEdge(6, 8);
		lca.addEdge(5, 7);
		lca.addEdge(7, 8);
		lca.addEdge(8, 9);

		assertEquals("Finding LCA for 4 and 5", 1, lca.findLCA(5, 4));
		assertEquals("Finding LCA for 7 and 8", 7, lca.findLCA(8, 7));
		assertEquals("Finding LCA for 6 and 8", 6, lca.findLCA(6, 8));
		assertEquals("Special case where both parameters are same vertex", 2, lca.findLCA(2,2));
	}

}