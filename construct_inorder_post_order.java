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
    HashMap<Integer,Integer> mp=new HashMap<>();
    int postindex;
    public  TreeNode build(int[] postorder, int[] inorder,int start,int end){
       
        if(start>end) return null;
        
        TreeNode root= new TreeNode(postorder[postindex--]);
        
         if(root==null)
            return null;
        
        if(start==end) return root;
        
        int index=mp.get(root.val);
        
        root.right=build(postorder,inorder,index+1,end);
        root.left=build(postorder,inorder,start,index-1);
       
  
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = inorder.length - 1;
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        
        return build(postorder,inorder,0,inorder.length-1);
        
    }
}
