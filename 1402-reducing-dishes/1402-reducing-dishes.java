class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length, ans = 0, preSum = 0, timeCoefficient = 0;
        for (int i = n-1; i >= 0; i--) {
            if (preSum + satisfaction[i] <= 0) {
                break;
            }
            preSum += satisfaction[i];
            timeCoefficient += preSum;
            ans = Math.max(ans, timeCoefficient);
        }
        return ans;
    }
}