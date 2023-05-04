class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;//traverse consecutive 1's
        int maxi=0;//it checks maximum 1's
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
            }
            else{
                cnt=0;
            }
            maxi=Math.max(maxi,cnt);
        }
        return maxi;
        
    }
}