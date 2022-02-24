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
  public static ArrayList<ArrayList<Integer>> result;
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    result = new ArrayList<ArrayList<Integer>>();
	    solve(root, sum, new ArrayList<Integer>());
	    return result;
	}
	
	public void solve(TreeNode curr, int sum, ArrayList<Integer> path) {
	    if(curr.left == null && curr.right == null && curr.val == sum) {
	        path.add(curr.val);
	        result.add(new ArrayList<Integer>(path));
	        path.remove(path.size() - 1);
	        return;
	    }
	    path.add(curr.val);
	    if(curr.left != null) {
	        solve(curr.left, sum - curr.val, path);
	    }
	    if(curr.right != null) {
	        solve(curr.right, sum - curr.val, path);
	    }
	    path.remove(path.size() - 1);
	}
}
