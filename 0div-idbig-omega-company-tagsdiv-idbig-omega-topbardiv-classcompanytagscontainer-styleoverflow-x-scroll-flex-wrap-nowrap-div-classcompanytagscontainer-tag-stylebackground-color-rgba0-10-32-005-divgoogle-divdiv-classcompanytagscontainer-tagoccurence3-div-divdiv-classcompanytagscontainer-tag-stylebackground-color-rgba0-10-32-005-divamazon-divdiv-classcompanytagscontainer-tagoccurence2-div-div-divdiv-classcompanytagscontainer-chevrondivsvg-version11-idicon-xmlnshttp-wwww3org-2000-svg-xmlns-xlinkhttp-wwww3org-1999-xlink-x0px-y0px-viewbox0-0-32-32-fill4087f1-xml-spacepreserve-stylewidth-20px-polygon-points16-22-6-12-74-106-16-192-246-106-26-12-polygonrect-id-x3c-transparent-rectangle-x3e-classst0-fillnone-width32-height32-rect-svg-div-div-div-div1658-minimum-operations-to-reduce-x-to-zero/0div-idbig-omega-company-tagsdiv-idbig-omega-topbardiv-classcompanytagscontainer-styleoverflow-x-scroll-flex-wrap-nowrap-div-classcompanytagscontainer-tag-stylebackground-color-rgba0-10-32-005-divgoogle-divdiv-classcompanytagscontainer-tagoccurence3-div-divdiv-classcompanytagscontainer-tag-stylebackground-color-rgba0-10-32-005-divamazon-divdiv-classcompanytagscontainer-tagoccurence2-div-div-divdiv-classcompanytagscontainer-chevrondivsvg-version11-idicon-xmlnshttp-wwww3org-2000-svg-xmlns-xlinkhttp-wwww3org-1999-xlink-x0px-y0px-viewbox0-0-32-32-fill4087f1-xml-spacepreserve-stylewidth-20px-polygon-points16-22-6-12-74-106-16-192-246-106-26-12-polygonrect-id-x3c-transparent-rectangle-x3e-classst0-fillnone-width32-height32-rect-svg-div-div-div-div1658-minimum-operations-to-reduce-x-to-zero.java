class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum() - x;

        if (target < 0) {
            return -1; // If the target is negative, it's impossible to reach zero.
        }

        int left = 0;
        int sum = 0;
        int minOperations = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                minOperations = Math.min(minOperations, n - (right - left + 1));
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}