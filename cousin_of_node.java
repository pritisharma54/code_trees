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
    public ArrayList<Integer> solve(TreeNode A, int B) {
         ArrayList<Integer> arr = new ArrayList<Integer>();
         if(A==null || A.val==B){
            return arr;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
       
        Boolean flag = false;
        TreeNode cur = null;
        q.add(A);
        while(!q.isEmpty() && !flag){
            int s = q.size();
            while(s-->0){
                cur=q.poll();
                if((cur.left!=null && cur.left.val==B) || (cur.right!=null && cur.right.val==B)){
                        flag = true;
                    
                }else{
                    if(cur.left!=null && cur.left.val!=B){
                        q.add(cur.left);
                    }
                    if(cur.right!=null && cur.right.val!=B){
                        q.add(cur.right);
                    }
                }
            }
        }
        if(flag){
            while(!q.isEmpty()){
                cur=q.poll();
                arr.add(cur.val);
            }
            
        }
       return arr;
    }
}
