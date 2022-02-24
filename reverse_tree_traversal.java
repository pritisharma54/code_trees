/**
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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if(A == null)
        {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(A);
        
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            res.add(n.val);
            
            if(n.right!=null)
            {
                q.offer(n.right);
            }
            
            if(n.left!=null)
            {
                q.offer(n.left);
            }
        }
        
        Collections.reverse(res);
        
        return res;
    }
    
}
