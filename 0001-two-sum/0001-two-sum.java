// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Arrays.sort(nums);
//         int left=0;int right= nums.length-1;
//         while(left<right){
//             int sum=nums[left]+nums[right];
//             if(sum==target){
//                 System.out.println("Yes");
//             }else if(sum<target)left++;
//             else right--;
//             }
//         return "No";
//         }
//         String ans = twoSum(nums, target);
//         return(ans);

//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int num =nums[i];
            int mr= target -num;
            if(mp.containsKey(mr)){
                ans[0]=mp.get(mr);
                ans[1]= i;
                return ans;

            }
            mp.put(nums[i], i);
        }
        return ans;
        
    }
}