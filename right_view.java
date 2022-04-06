*************************************************************

    Following is the Binary Tree node structure:

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/
import java.util.ArrayList;

public class Solution {

    public static void util(BinaryTreeNode<Integer> root, int level,ArrayList<Integer> res) 
    {
       if(root==null) return;
       if(res.size()==level) res.add(root.data);
       
       util(root.right,level+1,res);
       util(root.left,level+1,res);  
    }
    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res= new ArrayList<>();
        util(root,0,res);
        
        return res;
    }
}
Level order
/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where N is the number of BinaryTreeNodes in the tree.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
        // It is used to store the answer.
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Queue used to do level order traversal.
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        // Traverse till the queue becomes empty.
        while (!q.isEmpty()) {

            // Number of BinaryTreeNodes at the current level.
            int n = q.size();

            // Traverse all BinaryTreeNodes of current the level.
            for (int i = 1; i <= n; i++) {

                BinaryTreeNode<Integer> temp = q.poll();

                // Add the right most element at the current level.
                if (i == n) {
                    ans.add(temp.data);
                }

                // Add left BinaryTreeNode to the queue.
                if (temp.left != null) {
                    q.offer(temp.left);
                }

                // Add right BinaryTreeNode to the queue.
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }

        return ans;
    }
}
