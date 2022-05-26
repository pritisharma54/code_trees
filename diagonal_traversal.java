/************************************************************
https://www.codingninjas.com/codestudio/problems/diagonal-traversal-of-a-binary-tree_920477?leftPanelTab=0
    Following is the TreeNode class structure:
    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;
public class Solution {
    public static ArrayList<Integer> diagonalTraversal(TreeNode<Integer> root) {
        // Write your code here.
		
		Queue<TreeNode<Integer>> que= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
		que.add(root);
		
		while(que.size()!=0){
			int size=que.size();
			while(size-->0){
				TreeNode<Integer> rn= que.poll();
					while(rn!=null){
						ans.add(rn.data);
						if(rn.left!=null)
							que.add(rn.left);
						rn=rn.right;
				    }	
			}

		}
		
		return ans;
	
    }
}
