class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;//make one sign variable which is product
        
        for (int num : nums) {//iteate array elements
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign = -sign;//if neg flip sign
            }
        }
        
        return sign;
    }
}
