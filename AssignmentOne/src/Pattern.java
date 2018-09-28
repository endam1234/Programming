import java.util.List;
import java.util.ArrayList;

public class Pattern  
{ 
  
    BinaryNode root; 
    private List<Integer> pathA = new ArrayList<>(); 
    private List<Integer> pathB = new ArrayList<>(); 
  
    // Finds the path from root node to given root of the tree. 
    int findLCA(int x, int y) 
    { 
        pathA.clear(); 
        pathB.clear(); 
        return LowestInternal(root, x, y); 
    } 
  
    private int LowestInternal(BinaryNode root, int x, int y) 
    { 
  
        if (!findPath(root, x, pathA) || !findPath(root, y, pathB)) 
        { 
            System.out.println((pathA.size() > 0) ? "x is present" : "x is missing"); 
            System.out.println((pathB.size() > 0) ? "y is present" : "y is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < pathA.size() && i < pathB.size(); i++) 
        { 
            if (!pathA.get(i).equals(pathB.get(i))) 
                break; 
        } 
  
        return pathA.get(i-1); 
    } 
      
    // Finds the path from root node to given root
    private boolean findPath(BinaryNode root, int j, List<Integer> path) 
    {
        if (root == null) 
        { 
            return false; 
        } 
          
        // Stores node
        path.add(root.data); 
  
        if (root.data == j) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, j, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, j, path)) { 
            return true; 
        } 
  
        path.remove(path.size()-1); 
  
        return false; 
    } 


public static void main(String[] args) 
{ 
    Pattern tree = new Pattern(); 
    tree.root = new BinaryNode(1); 
    tree.root.left = new BinaryNode(2); 
    tree.root.right = new BinaryNode(3); 
    tree.root.left.left = new BinaryNode(4); 
    tree.root.left.right = new BinaryNode(5); 
    tree.root.right.left = new BinaryNode(6); 
    tree.root.right.right = new BinaryNode(7); 

    System.out.println("Lowest Common Ancestor(2, 4): " + tree.findLCA(2,4)); 
    System.out.println("Lowest Common Ancestor(3, 4): " + tree.findLCA(3,4)); 
    System.out.println("Lowest Common Ancestor(4, 5): " + tree.findLCA(4,5)); 
    System.out.println("Lowest Common Ancestor(4, 6): " + tree.findLCA(4,6)); 
  
} 
} 