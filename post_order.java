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
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
      TreeNode curr = a;
	    Stack<TreeNode> s = new Stack<>();
	    ArrayList<Integer> result = new ArrayList<>();
	    s.push(a);
	    while(!s.isEmpty()) {
	        curr = s.pop();
	        result.add(curr.val);
	        if(curr.left != null) {
	            s.push(curr.left);
	        }
	        if(curr.right != null) {
	            s.push(curr.right);
	        }
	    }
        Collections.reverse(result);
	    return result;
    }
}
