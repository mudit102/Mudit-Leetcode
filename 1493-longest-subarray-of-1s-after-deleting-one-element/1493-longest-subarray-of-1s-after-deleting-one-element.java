class Solution {
    public int longestSubarray(int[] nums) {
        int cur = 0 , prev = 0;
        int ans = 0;
        for(int i : nums){
            if(i == 1) cur++;
            else{
                ans = Math.max(ans , cur+prev);
                prev = cur;
                cur = 0;
            }
        }
        ans = Math.max(ans , cur+prev);

        return ans == nums.length?ans-1:ans;
    }
}