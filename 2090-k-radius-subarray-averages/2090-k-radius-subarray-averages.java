class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        // Create an array to store the mid vals if present
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        // End bounds check
        if (n % 2 == 0 && n / 2 <= k) {
            return ans;
        } else if (n % 2 != 0 && n / 2 < k) {
            return ans;
        }

        int j = 0, i = 0, sz = 2 * k + 1, m = k;
        long s = 0;
        // Iteration over the array
        while (i < n && j < n) {
            s += nums[i];
            if (i - j + 1 == sz) {
                ans[m] = (int) (s / sz);
                s -= nums[j];
                j++;
                m++;
            }
            i++;
        }
        return ans;
    }
};