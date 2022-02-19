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
    boolean ans =false;
    int func(TreeNode A){
        if(A==null) return(0);
        int left = func(A.left);
        int right= func(A.right);
        if(Math.abs(left-right)>1){
            ans=true;
        }
        return(1+Math.max(left,right));
    }
    public int isBalanced(TreeNode A) {
        func(A);
        return(ans?0:1);
    }
}
