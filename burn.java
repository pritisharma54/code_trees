**
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
  
    public int solve(TreeNode A, int B) {
        // Initialize map to store edges and vertices.
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        TreeNode start=null;

        // Initialize queue for bfs traversal.
        Queue<TreeNode> q = new LinkedList<>();
     
        int [] visited= new int[100000];
        Arrays.fill(visited,-1);

        q.add(A);
        // To inserting all nodes parent
        while(q.isEmpty() == false)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.peek();
                if(temp.val == B)
                start=temp;
                q.poll();
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    mp.put(temp.left,temp);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    mp.put(temp.right,temp);
                }

            }
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.add(start);
        int burnTime=0;
        while(nq.isEmpty() == false)
        {
            int size=nq.size();
            int fl = 0;
            for(int i=0; i<size; i++)
            {
            TreeNode Temp=nq.peek();
            nq.poll();
            visited[Temp.val]=1;
                if(mp.containsKey(Temp))
                {
                    TreeNode parent=mp.get(Temp);
                    if(visited[parent.val] == -1)
                    {
                        visited[parent.val] = 1;
                        nq.add(parent);
                        fl = 1;
                    }
                }
                if(Temp.left!=null && visited[Temp.left.val]==-1)
                {
                    visited[Temp.left.val]=1;
                    nq.add(Temp.left);
                    fl = 1;
                }
                if(Temp.right!=null && visited[Temp.right.val]==-1)
                {
                    visited[Temp.right.val]=1;
                    nq.add(Temp.right);
                    fl = 1;
                }

            }
            if(fl == 1)   burnTime++;

        }

        return burnTime;
        
    }
}
