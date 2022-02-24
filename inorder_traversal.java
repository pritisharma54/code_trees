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
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
       
      Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(A);
        TreeNode cur = A;
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            if(cur != null && cur.left != null){
                st.add(cur.left);
                cur = cur.left;
            }else{
                TreeNode temp = st.pop();
                list.add(temp.val);
                cur = temp.right;
                if(cur != null){
                    st.add(cur);
                }
            }
        }
        return list;
    }
}
