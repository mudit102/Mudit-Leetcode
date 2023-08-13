class Solution {
    int n;
    public boolean validPartition(int[] nums) {
        this.n = nums.length;
        Boolean[] memo = new Boolean[n];
        return dfs(0, nums, memo);
    }
    boolean isValid(int a, int b) {
        return a == b;
    }
    boolean isValid(int a, int b, int c) {
        return (a == b) && (b == c);
    }
    boolean isConsecutive(int a, int b, int c) {
        return (c-b == 1) && (b-a == 1);
    }
    boolean dfs(int idx, int[] nums, Boolean[] memo) {
        if(idx == n) {
            return true;
        }
        if(n-idx < 2) {
            return false;
        }
        if(memo[idx] != null) {
            return memo[idx];
        }
        // take 2 equal
        boolean take2 = isValid(nums[idx], nums[idx+1]) && dfs(idx+2, nums, memo);
        if(n-idx < 3) {
            // we don't need to consider 3 length subarray.
            return memo[idx] = take2;
        }
        // take 3 equal or consecutive increasing
        boolean take3 = (isValid(nums[idx], nums[idx+1], nums[idx+2]) || isConsecutive(nums[idx], nums[idx+1], nums[idx+2])) && dfs(idx+3, nums, memo);
        return memo[idx] = (take2 || take3);
    }
}