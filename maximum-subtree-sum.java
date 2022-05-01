/*
    Time Complexity: O(N)
    Space Complexity: O(M),

    Where N is the number of nodes and M is the complexity of recursion stack.
	https://www.codingninjas.com/codestudio/problems/maximum-subtree-sum_1082330?leftPanelTab=0
*/

public class Solution {
    // We will store the answer in ans variable.
	public static long ans=0;
	
	public static long maxSubtreeSumHelper(BinaryTreeNode<Integer> root){
		
		if(root==null) return 0;
		
		long currTreeSum=(long)root.data+maxSubtreeSumHelper(root.left)+maxSubtreeSumHelper(root.right);
		
		ans=Math.max(ans,currTreeSum);
		
		return currTreeSum;
		
	}
   
    public static long maxSubtreeSum(BinaryTreeNode<Integer> root) {
		ans=Long.MIN_VALUE;
		maxSubtreeSumHelper(root);
		
		return ans;
    }

}
