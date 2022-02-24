public class Solution {
    public int solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        int root = -2147483648;
        for(int i=0;i<A.size();i++){
            if(A.get(i)<root ){
                return 0;
            }
            while(!stack.empty()&&stack.peek()<A.get(i)){
                root=stack.peek();
                stack.pop();
            }
            stack.push(A.get(i));
        }
        return 1;
    }
}
