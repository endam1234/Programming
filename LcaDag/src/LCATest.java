import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

	@Test
	public void testLCA() {

		LCA<Integer, Integer> a = new LCA<Integer, Integer>();
		assertSame("Testing LCA for null root", null, a.lowestCommonAncestor(a.root, 1, 2));

		a.put(7, 7);   //        _7_

		a.put(8, 8);   //      /     \

		a.put(3, 3);   //    _3_      8

		a.put(1, 1);   //  /     \

		a.put(2, 2);   // 1       6

		a.put(6, 6);   //  \     /

		a.put(4, 4);   //   2   4

		a.put(5, 5);   //        \

		//        				 	5

		assertSame("Testing LCA left side", 3, a.lowestCommonAncestor(a.root, 2,6));
		assertSame("Testing LCA right side", 7, a.lowestCommonAncestor(a.root, 8,3));

		assertSame("Testing LCA, where LCA is one of the nodes", 7, a.lowestCommonAncestor(a.root, 7,8));
		assertSame("Testing LCA, where LCA is one of the nodes", 7, a.lowestCommonAncestor(a.root, 3,7));
	}

	@Test

	public void testDelete() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		LCA.delete(1);
		assertEquals("Deleting from empty tree", "()", LCA.printKeysInOrder());

		LCA.put(7, 7);   //        _7_

		LCA.put(8, 8);   //      /     \

		LCA.put(3, 3);   //    _3_      8

		LCA.put(1, 1);   //  /     \

		LCA.put(2, 2);   // 1       6

		LCA.put(6, 6);   //  \     /

		LCA.put(4, 4);   //   2   4

		LCA.put(5, 5);   //        \

						 //          5

		assertEquals("Checking order of constructed tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeysInOrder());

		LCA.delete(11);
		assertEquals("Deleting non-existent key", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeysInOrder());

		LCA.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", LCA.printKeysInOrder());

		LCA.delete(6);
		assertEquals("Deleting node with single child", "(((()1(()2()))3(()4(()5())))7())", LCA.printKeysInOrder());
		
		LCA.delete(3);
		assertEquals("Deleting node with two children", "(((()1())2(()4(()5())))7())", LCA.printKeysInOrder());
	}

	@Test

	public void testPut() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		LCA.put(1, null);
		LCA.put(10, 1);
		LCA.put(15,2);
		LCA.put(15, 15);	 

		assertEquals("Putting nodes", "(()10(()15()))", LCA.printKeysInOrder());
	}
	
	@Test

	public void testGet() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		assertEquals("Test empty", false, LCA.contains(5));
		LCA.put(1, null);
		LCA.put(10, 1);
		LCA.put(5, 9);
		LCA.put(15,2);
		LCA.put(9, 15);	 

		assertEquals("Test left", "9", LCA.get(5).toString());
		assertEquals("Test right then right", "2", LCA.get(15).toString());
		assertEquals("Test right then left", "15", LCA.get(9).toString());
		assertEquals("Test root", "1", LCA.get(10).toString());
	}

}