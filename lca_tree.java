/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
   public boolean find(TreeNode root, int k)
    {
    // Base Case
        if (root == null)
            return false;
        return  (root.val == k || find(root.left, k) ||  find(root.right, k));
    }
    
    public TreeNode lca_util(TreeNode root, int val1, int val2) {
        
	    if(root == null || root.val == val1 || root.val == val2) return root;
	    TreeNode left = lca_util(root.left, val1 , val2);
	    TreeNode right = lca_util(root.right, val1 , val2);
	    if(left!=null && right!=null) return root;
	    return left!=null ? left : right ;
    }
    
	public int lca(TreeNode root, int val1, int val2) {
        if(!find(root, val1) || !find(root, val2))
            return -1;
        TreeNode result =  lca_util(root ,val1, val2); 
        return result!= null? result.val : -1;
	}
}
