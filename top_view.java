/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
public class Solution {
    static class Pair{
        int hd;
        BinaryTreeNode node;
        
        public Pair(int hd, BinaryTreeNode node){
            this.hd=hd;
            this.node=node;
        }
    }
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        
        ArrayList<Integer> res= new ArrayList<>();
        if (root == null) {
			return res;
		}
        
        Queue<Pair> q= new LinkedList<>();
        
        Map<Integer,Integer> mp= new TreeMap<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair cur= q.poll();
            
            if(!mp.containsKey(cur.hd))
                mp.put(cur.hd,cur.node.val);
            
            if(cur.node.left!=null)
                 q.add(new Pair(cur.hd-1,cur.node.left));
            if(cur.node.right!=null)
                 q.add(new Pair(cur.hd+1,cur.node.right));
            
        }
        
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            res.add(entry.getValue());
        }
        return res;
	}
}
