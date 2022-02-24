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
    public int lastNode(TreeNode A) {
        if(A==null) return 0;

        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(q.size()>0){
            int n = q.size();
            for(int i=1;i<=n;i++){
                TreeNode s = q.peek(); 
                q.remove();
                if(i==n)
                  ans = s.val;
                if(s.left!=null) q.add(s.left);
                if(s.right!=null) q.add(s.right);  
            }
        }
        return ans;
    }
}
