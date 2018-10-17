import java.util.ArrayList;

public class LCA <Key extends Comparable<Key>, Value>{
	Node root;

	class Node {
		private Key key;           				
		private Value value;         				
		private Node left, right; 				
		private int N;             				

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	class DAG {

		private Node root;
		public DAG(Node root) {
			this.root = root;
		}
	}
	
	public boolean isEmpty() { 
		return size() == 0; 
	}

	public int size() { 
		return size(root); 
	}

	private int size(Node x) {
		if (x == null) return 0;
		//N is number of nodes

		else return x.N;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}



	//Search BST for given key.

	public Value get(Key key) { 
		return get(root, key); 
	}

	private Value get(Node node, Key key) {
		if (node == null) return null;

		int compare = key.compareTo(node.key);

		if(compare < 0) return get(node.left, key);
		else if (compare > 0) return get(node.right, key);
		else return node.value;	
	}

	 //Insert key-value pair into BST.

	 //If key already exists, update with new value.

	public void put(Key key, Value value) {

		if (value == null) { delete(key); return; }
		root = put(root, key, value);

	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) return new Node(key, value, 1); //new BST

		int compare = key.compareTo(node.key);

		if(compare < 0) node.left  = put(node.left,  key, value);
		else if (compare > 0) node.right = put(node.right, key, value);
		else node.value = value; //update value

		node.N = 1 + size(node.left) + size(node.right); 
		return node;
	}

	


	/**
	 * Tree height.
	 * Asymptotic worst-case running time using Theta notation: worst case O(N) which would occur when
	 * the tree would act as a list, that meaning either all the nodes are to right or all the nods are to the left
	 * when N is the number of nodes in the BST.
	 * @return the number of links from the root to the deepest leaf.
	 * Example 1: for an empty tree this should return -1.
	 * Example 2: for a tree with only one node it should return 0.
	 * Example 3: for the following tree it should return 2.

	 *   B

	 *  / \

	 * A   C

	 *      \

	 *       D

	 */



	public int height() { 
		return height(root); 
	}

	private int height(Node x) {
		if (x == null) {
			return -1;
		}
		else {
			return 1 + Math.max(height(x.left), height(x.right));
		}
	}

	public Key median() {
		if (isEmpty()) return null; //returning null if the tree is empty

		else {
			int median=(((size(root)+1)/2)-1); 
			return intToKey(median);
		}
	}

	private Key intToKey(int passedInteger) {                       
		Node node = intToKey(root, passedInteger);
		return node.key;
	}

	private Node intToKey(Node node, int passedInt) {     
		int leftSize = (size(node.left));  

		//left or right subtree

		if (leftSize > passedInt) {
			return intToKey(node.left,  passedInt); 
		}
		else if (leftSize < passedInt) {
			return intToKey(node.right, passedInt-leftSize-1); 
		}
		else {
			return node; 
		}
	} 





	/**
	 * Print all keys of the tree in a sequence, in-order.
	 * Also, for each node, the keys in the right subtree should appear before the key in the node.
	 * Example 1: Empty tree -- output: "()"
	 * Example 2: Tree containing only "A" -- output: "(()A())"
	 * Example 3: Tree:

	 *   B

	 *  / \

	 * A   C

	 *      \

	 *       D


	 */

	public String printKeysInOrder() {

		String result= "";
		if (isEmpty()){
			return result += "()";
		}
		else {
			return result = printKeysInOrder(root);
		}
	}

	 private String printKeysInOrder(Node node) {

		 String result = "";
		 if (node == null) {
			 return result += "()";
		 }

		 else {
			return result += ("(" + printKeysInOrder(node.left) + node.key.toString() + printKeysInOrder(node.right) + ")");
		 }

	 }
	/**
	 * Deletes a key from a tree (if the key is in the tree).
	 * If the node to be deleted has two child nodes, then it needs to be
	 * replaced with its predecessor (not its successor) node.
	 */

	public void delete(Key key) {
		root = delete(root, key);	
	}

	private Node delete (Node node, Key key) {
		if (node == null) { 
			return null;
		}

        int compare = key.compareTo(node.key);

        if(compare > 0) {
        	node.right = delete(node.right, key);
        	node.left  = delete(node.left,  key);
        }
        else if (compare < 0) {
        	node.left  = delete(node.left,  key);
        }
        else {
        	if (node.right == null) {
        		return node.left;
        	}
            if (node.left  == null) {
            	return node.right;
            }
            Node temp = node;
            node = max(temp.left);                              
            node.left = deleteMax(temp.left);                 
            node.right = temp.right; 
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
	}

	private Node deleteMax(Node node) 
    {
        if(node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;                                 
        return node;
    }

	public Node max(Node node)
	{
	     if(node.right!=null) {
	       return max(node.right);
	     }
	     return node;
	   }

	// Used: geeksforgeeks as assistance in this assignment

	 	public Key lowestCommonAncestor (Node node, Key key1, Key key2){
	 		if (node == null)
	             return null;

	 		if (node.key == key1) {
	 			return node.key;
	 		}

	 		if (node.key == key2) {
	 			return node.key;
	 		}

	 		int cmp1= node.key.compareTo(key1);
	 		int cmp2 = node.key.compareTo(key2);

	         if (cmp1 >= 0 && cmp2 >= 0)
	             return lowestCommonAncestor(node.left, key1, key2);

	         if (cmp1 <= 0 && cmp2 <= 0)
	             return lowestCommonAncestor(node.right, key1, key2);

	         return node.key;
	 	}
}
	 	

	

