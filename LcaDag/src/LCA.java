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
}





