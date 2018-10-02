
class BinaryNode {

	int data;
	BinaryNode left, right;

	BinaryNode(int value) {
		data = value;
		left = right = null;
	}
}



public class LCA {
	
	BinaryNode root;

	BinaryNode findLCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	BinaryNode findLCA(BinaryNode node, int n1, int n2) {
		
		if (node == null) {
			return null;
		}
		if (node.data == n1 || node.data == n2) {
			return node;
		}
		BinaryNode left = findLCA(node.left, n1, n2);
		BinaryNode right = findLCA(node.right, n1, n2);

		if (left != null && right != null) {
			return node;
		}
		if (left != null) {
			return left;
		} 
		else {
			return right;
		}

	}
}
