//https://www.codingninjas.com/codestudio/problems/maximum-difference-between-a-node-and-its-descendant_630284?leftPanelTab=0
/*
    Following is the Node class already written for the Binary Tree.

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
*/
public class Solution {
	public static int maximumDifferenceNodeAndAncestorHelper(BinaryTreeNode<Integer> root,int max,int min) {
        // Your code goes here.
		if(root==null)
			return 0;
		max=Math.max(max,root.data);
		min=Math.min(min,root.data);
		
		int currSubdiff=max-min;
		
		int subTreeDiff=Math.max(maximumDifferenceNodeAndAncestorHelper(root.left,max,min),maximumDifferenceNodeAndAncestorHelper(root.right,max,min));
	
		return Math.max(currSubdiff,subTreeDiff);
    }
    public static int maximumDifferenceNodeAndAncestor(BinaryTreeNode<Integer> root) {
        // Your code goes here.
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		return maximumDifferenceNodeAndAncestorHelper(root,max,min);
    }
}
