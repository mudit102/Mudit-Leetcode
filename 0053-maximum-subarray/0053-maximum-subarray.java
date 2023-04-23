class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maximumSum = Integer.MIN_VALUE, currSumSubarray = 0;
        for (int i = 0; i < n; i++) {
            currSumSubarray += nums[i]; 
            maximumSum = Math.max(maximumSum, currSumSubarray);
            currSumSubarray = Math.max(currSumSubarray, 0);
        } 
        return maximumSum;
    }
}