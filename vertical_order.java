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
    static class Pair{
        int hd;
        TreeNode node;
        
        public Pair(int hd,TreeNode node){
            this.hd=hd;
            this.node=node;
        }
   
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer> > map = new TreeMap<>();

        if(root==null) return res;
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair curr=q.poll();
            
            if(!map.containsKey(curr.hd)){
               ArrayList<Integer> temp= new ArrayList<>();
               temp.add(curr.node.val);
               map.put(curr.hd,temp);
            }else{
                map.get(curr.hd).add(curr.node.val);
            }
            
            if(curr.node.left!=null)
                q.add(new Pair(curr.hd-1,curr.node.left));
            if(curr.node.right!=null)
                q.add(new Pair(curr.hd+1,curr.node.right));
  
        }
        // Traverse the map and print nodes at
        // every horizontal distance (hd)
        for (Map.Entry<Integer, ArrayList<Integer> > entry : map.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
                res.add(al);
        }

        return res;
    }
}


//returning as arraylist
 for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            res.addAll(entry.getValue());
        }
