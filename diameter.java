*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {
    public static int ans=0;
    public static int height(BinaryTreeNode<Integer> root){
		//Your code goes here
        if(root==null) return 0;
        
        int lh=height(root.left);
        int rh=height(root.right);
        
        ans=Math.max(ans,1+lh+rh);
       return 1+ Math.max(lh,rh);
	}

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
        int h=height(root);
        
        return ans;
	}
    
    
	
}
