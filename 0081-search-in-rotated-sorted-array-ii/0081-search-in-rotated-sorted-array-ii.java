class Solution {
    public boolean search(int[] nums, int target) {
        int i=0, n=nums.length, j=n-1, mid;
        while(i<=j){
            mid=(i+j)/2;
            if(nums[mid]==target || nums[i]==target || nums[j]==target) return true;
            if(nums[i]==nums[j]){
                i++;
                j--;
                continue;
            }

            if(nums[i]<=nums[mid]){
                if(nums[i]<=target){
                    if(nums[mid]<target) i=mid+1;
                    else j=mid-1;
                }else{
                    i=mid+1;
                }
            }else{
                if(nums[i]>target) {
                    if(nums[mid]<target) i=mid+1;
                    else j=mid-1;
                }
                else j=mid-1;
            }
        }
        return false;
    }
}