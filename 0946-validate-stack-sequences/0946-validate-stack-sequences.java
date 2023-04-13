class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int each : pushed){
            stack.push(each);
            while(!stack.isEmpty() 
                    && j<popped.length //take care of overflow case
                    && stack.peek()==popped[j]){
                j++;
                stack.pop();
            }
        }
        return j==popped.length;
    }
}