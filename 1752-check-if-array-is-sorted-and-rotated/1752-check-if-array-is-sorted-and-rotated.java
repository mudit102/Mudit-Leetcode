class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int ctr=0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                ctr++;
            }
        }
        if(ctr>1){
                return false;
            }
        return true;
    }
}