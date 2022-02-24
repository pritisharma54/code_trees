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
 
    private boolean has(TreeNode node, int sumc)
    {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && sumc == node.val)
            return true;
        return has(node.left, sumc-node.val)||has(node.right,sumc-node.val);
    }
	public int hasPathSum(TreeNode a, int b){
	    return (has(a,b) == true)?1:0;
	}
}
