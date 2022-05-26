
import java.util.HashMap;
import java.util.*;


public class Solution
{
    static int maxTime;
     public static void burnTreeUtil(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> blocker,int time){
         if(root==null||root==blocker) return;
             
         maxTime=Math.max(maxTime,time);
         
         burnTreeUtil(root.left,blocker,time+1);
         burnTreeUtil(root.right,blocker,time+1);
     }
    
     public static int burnTree(BinaryTreeNode<Integer> root, int target){
         
         if(root==null) return -1;
         if(root.data==target){
             burnTreeUtil(root,null,0);
             return 1;
             
         }
         int leftime=burnTree(root.left,target);
         if(leftime!=-1){
              burnTreeUtil(root,root.left,leftime);
              return leftime+1;
         }
         
         int rightime=burnTree(root.right,target);
         if(rightime!=-1){
              burnTreeUtil(root,root.right,rightime);
              return rightime+1;
         }
         
         return -1;
    
     }
  
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int target)
    {
       maxTime=0;
       burnTree(root,target);
       return maxTime;
  
    }
}



@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@






**
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
  
    public int solve(TreeNode A, int B) {
        // Initialize map to store edges and vertices.
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        TreeNode start=null;

        // Initialize queue for bfs traversal.
        Queue<TreeNode> q = new LinkedList<>();
     
        int [] visited= new int[100000];
        Arrays.fill(visited,-1);

        q.add(A);
        // To inserting all nodes parent
        while(q.isEmpty() == false)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.peek();
                if(temp.val == B)
                start=temp;
                q.poll();
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    mp.put(temp.left,temp);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    mp.put(temp.right,temp);
                }

            }
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.add(start);
        int burnTime=0;
        while(nq.isEmpty() == false)
        {
            int size=nq.size();
            int fl = 0;
            for(int i=0; i<size; i++)
            {
            TreeNode Temp=nq.peek();
            nq.poll();
            visited[Temp.val]=1;
                if(mp.containsKey(Temp))
                {
                    TreeNode parent=mp.get(Temp);
                    if(visited[parent.val] == -1)
                    {
                        visited[parent.val] = 1;
                        nq.add(parent);
                        fl = 1;
                    }
                }
                if(Temp.left!=null && visited[Temp.left.val]==-1)
                {
                    visited[Temp.left.val]=1;
                    nq.add(Temp.left);
                    fl = 1;
                }
                if(Temp.right!=null && visited[Temp.right.val]==-1)
                {
                    visited[Temp.right.val]=1;
                    nq.add(Temp.right);
                    fl = 1;
                }

            }
            if(fl == 1)   burnTime++;

        }

        return burnTime;
        
    }
}
