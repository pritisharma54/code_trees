/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        
        while (!deque.isEmpty()) {
            int size = deque.size();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.pollFirst();
                if (temp.left != null) {
                    deque.add(temp.left);
                    map.put(temp.left.val, temp.val);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                    map.put(temp.right.val, temp.val);
                }
            }
            if (map.containsKey(x) && map.containsKey(y) && map.get(x) != map.get(y))
                return true;
        }
        
        return false;
    }
    
    
}
