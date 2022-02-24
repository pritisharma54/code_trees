/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // if(root == null){
        //     return null;
        // }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeLinkNode next = null;
            for(int i=0;i<n;i++){
                TreeLinkNode temp = q.poll();
                temp.next = next;
                next = temp;
                
                if(temp.right!= null){
                    q.add(temp.right);
                }
                if(temp.left!= null){
                    q.add(temp.left);
                }
            }
        }
        //return root
        
    }
}
