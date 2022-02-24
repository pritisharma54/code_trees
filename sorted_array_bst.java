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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        
        TreeNode root = null;
        return createBST(A, 0, A.length-1);
        
    }
    public TreeNode createBST(int[] A, int start, int end){
        if(start>end) return null;
        
        int middle = (end+ start)/2;
        TreeNode root = new TreeNode(A[middle]);
        
        root.left = createBST(A, start, middle-1);
        root.right = createBST(A, middle+1, end);
        
        return root;
    }
}
