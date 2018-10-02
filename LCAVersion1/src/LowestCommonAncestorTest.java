import static org.junit.Assert.*;
import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testNodeConstructor(){
		BinaryNode temp = new BinaryNode(1);
		assertNotNull("Testing Node constructor: ", temp);
	}
	@Test

	public void testEmptyTree() {
		
		LCA tree = new LCA();
		assertNull("Find LCA when tree is empty: ", tree.findLCA(1, 2));
		assertEquals("Find LCA when tree is empty: ", null, tree.findLCA(1, 2) );
	}

	@Test
	public void testTwoNodes(){
		LCA tree = new LCA();
		tree.root = new BinaryNode(1);
		tree.root.left = new BinaryNode(2);
		assertEquals("Find LCA of the tree with only root and one child: ", 1, tree.findLCA(1, 2).data);	
	}

	@Test
	public void testForNonExistentNodes(){

		LCA tree = new LCA();

		tree.root = new BinaryNode(1);
		tree.root.left = new BinaryNode(2);
		tree.root.right = new BinaryNode(3);
		tree.root.left.left = new BinaryNode(4);
		tree.root.left.right = new BinaryNode(5);
		tree.root.right.left = new BinaryNode(6);
		tree.root.right.right = new BinaryNode(7);
		assertEquals("Find ancestors of non-existent nodes in a populated tree: ", null, tree.findLCA(8, 9));
		assertEquals("Find ancestors of non-existent nodes in a populated tree: ", null, tree.findLCA(32, 76));
	}	
	

}

