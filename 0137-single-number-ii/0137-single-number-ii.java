class Solution {
     public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        int thrice = 0;
        for (int i = 0; i < nums.length; i ++){
            twice = twice | ( once & nums[i]);
            once = once ^ nums[i];
            thrice = once & twice;
            once = once & (~thrice);
            twice = twice & (~thrice);
        }
        return once;
    }
}