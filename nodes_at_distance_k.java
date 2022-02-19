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
    public static void printkdown(TreeNode node,int k,TreeNode blocker,ArrayList<Integer> result){
        if(node == null || k < 0 || node == blocker)
            return;
        if(k == 0){
            result.add(node.val);
            return;
        }

        printkdown(node.left,k-1,blocker,result);
        printkdown(node.right,k-1,blocker,result);

    }

   
    public static boolean find(TreeNode node,int data,ArrayList<TreeNode> path){
        if(node == null){
            return false;
        }
        if(node.val == data){
            path.add(node);
            return true;
        }

        boolean filc = find(node.left,data,path);
        if(filc){
            path.add(node);
            return true;
        }

        boolean firc = find(node.right,data,path);
        if(firc){
            path.add(node);
            return true;
        }

        return false;
}

        
    public ArrayList<Integer> distanceK(TreeNode root, int data, int k) {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        boolean flag=find(root,data,path);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<path.size();i++){
            printkdown(path.get(i),k-i,i == 0?null:path.get(i-1),result);
        }
        return result;
    }
}
