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
    TreeMap<Integer, Integer> mp;
    public  ArrayList<Integer> verticalSum(TreeNode A) {
        mp = new TreeMap<>();
        rec(A,0);
        ArrayList<Integer> ans = new ArrayList<>();
        int curr = 0;
        for(Map.Entry<Integer, Integer>e:mp.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
    public void rec(TreeNode root, int HD){
        if(root == null){
            return;
        }
        mp.putIfAbsent(HD, 0);
        mp.put(HD, mp.get(HD)+root.val);
        rec(root.left, HD-1);
        rec(root.right, HD+1);
    }
}
