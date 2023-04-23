class Solution {
    public int search(int[] nums, int key) {
        int start=0;
        int n=nums.length-1;
        int end=n;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==key){
                return mid;
            }
            if(nums[mid]<key){
                start=mid+1;
            }
            if(nums[mid]>key){
                end=mid-1;
            }
        }
        return -1;
        
    }
}