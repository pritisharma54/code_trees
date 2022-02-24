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

        LinkedList<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        que.addLast(root);

        while(que.size()!=0){

            int size=que.size();
            ArrayList<Integer> smallans = new ArrayList<>();

            while(size-->0){

                TreeNode rn=que.removeFirst();

                while(rn!=null){
                    smallans.add(rn.val);

                    if(rn.left!=null)
                        que.addLast(rn.left);
                    rn=rn.right;
                }
            }
            for(Integer val: smallans){
                ans.add(val);
            }
        }
        return ans;
    }
}
