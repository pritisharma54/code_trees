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
    int ans = 0;
    void count(TreeNode parent, TreeNode child){
        if(parent==null || child==null) return;
        if(Math.abs(parent.val-child.val)==1) ans++;
        count(child,child.left);
        count(child,child.right);
    }
    public int consecutiveNodes(TreeNode A) {
        if(A==null) return 0;
        count(A,A.left);
        count(A,A.right);

        return ans;
    }
}
