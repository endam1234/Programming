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
}
