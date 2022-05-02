/****************************************

Following is the BinaryTreeNode class structure

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
https://www.codingninjas.com/codestudio/problems/longest-univalue-path_985291?leftPanelTab=0

****************************************/

public class Solution {
	static int  maxpath=0;
	public static int longestUnivaluePathHelper(BinaryTreeNode root) {
		// Write your code here
		if(root==null)
			return 0;
			
		int leftPath=longestUnivaluePathHelper(root.left);
		int rightPath=longestUnivaluePathHelper(root.right);
		
		int leftMaxPath=0,rightMaxPath=0;
		
		if(root.left!=null&&root.data==root.left.data)
			leftMaxPath+=leftPath+1;
		if(root.right!=null&&root.data==root.right.data)
			rightMaxPath+=rightPath+1;
		
		maxpath=Math.max(maxpath,leftMaxPath+rightMaxPath);
		
		return Math.max(leftMaxPath,rightMaxPath);
		
		
	}
	public static int longestUnivaluePath(BinaryTreeNode root) {
		// Write your code here
		maxpath=0;
		longestUnivaluePathHelper(root);
		
		return maxpath;
		
		
	}
}
