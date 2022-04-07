/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
import java.util.*;
public class Solution {
  
    public static boolean util(BinaryTreeNode root, int k, HashSet<Integer> set) {
		// Write your code here.
       if(root==null) return false;
        
        if(util(root.left,k,set)==true)
            return true;
        if(set.contains(k-root.data))
            return true;
        set.add(root.data);
            
        
        return util(root.right,k,set);
	}
   
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
        HashSet<Integer> set= new HashSet<>();
            
        
        return util(root,k,set);
	}
}
