
/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where 'N' denotes the number of nodes in Binary Tree.
    https://www.codingninjas.com/codestudio/problems/left-sum_920380?leftPanelTab=2
*/

public class Solution {

	public static long leftSum(BinaryTreeNode<Integer> root) {
		return leftSumHelper(root, 0);
	}

	private static long leftSumHelper(BinaryTreeNode<Integer> root, int isLeft) {

	    // Base Case.
		if(root == null)
		{
			return 0;
		}

	    // Storing the sum of left nodes in 'l'.
		 long l = leftSumHelper(root.left, 1);

	    // Storing the sum of right nodes in 'r'.
		 long r = leftSumHelper(root.right, 0);

	    // If the node is the left node.
		if(isLeft != 0)
		{
			return (l + r + (long)(root.data));
		}

	    // If the bode is not the left node.
		return (l + r);
	}

}
