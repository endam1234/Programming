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

	
}

