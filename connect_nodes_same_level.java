//https://www.codingninjas.com/codestudio/problems/connect-nodes-at-same-level_985347?leftPanelTab=0
import java.util.*;
public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
		if(root==null)
			return;
		Queue<BinaryTreeNode<Integer>> que= new LinkedList<>();
		que.add(root);
		
		while(!que.isEmpty()){
			BinaryTreeNode<Integer> prev=null;
			int size=que.size();
			for(int i=0;i<size;i++){
				BinaryTreeNode<Integer> curr=que.poll();
				if(prev!=null)
					prev.next=curr;
				prev=curr;
				
				if(curr.left!=null)
					que.add(curr.left);
				if(curr.right!=null)
					que.add(curr.right);
		
			}
	
		}
		
		
	}
}
