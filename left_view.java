/************************************************************

    Following is the TreeNode class structure

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

import java.util.ArrayList;

public class Solution 
{	
	
 
 public static void util(TreeNode<Integer> root, int level,ArrayList<Integer> res) 
    {
       if(root==null) return;
       if(res.size()==level) res.add(root.data);
       
       util(root.left,level+1,res);
       util(root.right,level+1,res);  
    }
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res= new ArrayList<>();
        util(root,0,res);
        
        return res;
    }
}
Level order

/*
    Time Complexity - O(N)
    Space Complexity - O(N)

    Where N is the number of nodes in the Binary Tree.
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        
        //    For storing the left view.
        ArrayList<Integer> leftView =new ArrayList<Integer>();

        if (root == null) 
        {
            return leftView;
        }

        //    Queue for doing level order traversal.
        Queue<TreeNode<Integer>> level=new LinkedList<TreeNode<Integer>>();

        //    Push the root in the queue.
        level.add(root);
        int leftMostNode=-1;

        while (level.isEmpty() == false) 
        {
            
            //    Get the size of the current level.
            int queueSize = level.size();

            //    Traverse all nodes of the current level.
            for (int i = 0; i < queueSize; i++) 
            {
                
                //    Pop the node from the front of the queue.
                TreeNode<Integer> curr = level.remove();

                //    Store the left most node of the current level.
                if (i == 0) 
                {
                    leftMostNode = curr.data;
                }

                //    Push the left child into the queue.
                if (curr.left != null) {
                    level.add(curr.left);
                }

                //    Push the right child into the queue.
                if (curr.right != null) {
                    level.add(curr.right);
                }
            }

            //    Store the left most node of the current level in the array.
            leftView.add(leftMostNode);
        }

        //    Return the left view of the given binary tree.
        return leftView;
    }
}
