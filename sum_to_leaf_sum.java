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
public int sumNumbers(TreeNode a) {
	    if(a == null) return -1;
	    return sum(a, 0)%1003;
	}
	public static int sum(TreeNode a, int val){
	    if(a == null)return 0;
	    val = (val*10 + a.val)%1003;
	    if(a.left == null && a.right == null) return val;
	    int res = sum(a.left, val) + sum(a.right, val);
	    return res % 1003;
	}
    
}
