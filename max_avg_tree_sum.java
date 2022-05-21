/************************************************
    Binary Tree Node class for reference
    https://www.codingninjas.com/codestudio/problems/maximum-average-value-of-a-subtree_1281431?leftPanelTab=2

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }
 **********************************************/

public class Solution {
     static double maxAvg;
    public static int[] postOrderTravresal(TreeNode<Integer> root) {
        
        if(root==null){
            int res[]={0,0};
            return res;
        }
        
        int left[]=postOrderTravresal(root.left);
        int right[]=postOrderTravresal(root.right);
        
        
        int maxSum=left[0]+right[0]+root.data;
        int numNodes=left[1]+right[1]+1;
        
        maxAvg=Math.max(maxAvg,(double)maxSum/numNodes);
        
        int res[]={maxSum,numNodes} ;
        
        return res;
 
        
    }
    public static double maxSubtreeAverage(TreeNode<Integer> root) {
        // Write your code here.
        maxAvg=Double.MIN_VALUE-1e9;
        postOrderTravresal(root);
        
        return maxAvg;
    }
}
