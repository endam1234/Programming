import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	
	@Test
	public void testNodeConstructor(){
		
		BinaryNode temp = new BinaryNode(1);
		assertNotNull("Testing node constructor: ", temp);
	}
	
	@Test
	public void testEmptyTree() {
		
		Pattern tree = new Pattern();
		assertNull("Find LCA when tree is empty: ", tree.findLCA(1, 2));
		assertEquals("Find LCA when tree is empty: ", null, tree.findLCA(1, 2) );
	}

}
