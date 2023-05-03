// class Solution {
//     public int missingNumber(int[] nums) {
//         int xor1=0,xor2=0;
//         for(int i=0;i<nums.length-1;i++){
//             xor2=xor2^nums[i];
//             xor1=xor1^nums[i+1];
//         }
//         xor1=(xor1^xor2);
        
//     }
//     int answer=missingNumbers(nums);
//     System.out.print("The missing number is:"+answer);
// }
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = n * (n + 1) / 2;
        int arraySum = IntStream.of(nums).sum();
        return actualSum - arraySum;
    }
}