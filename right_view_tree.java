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
    public ArrayList<Integer> solve(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        while(q.size() > 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.remove();
                if(i == size-1) {
                    res.add(cur.val);
                }
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return res;
    }
}
