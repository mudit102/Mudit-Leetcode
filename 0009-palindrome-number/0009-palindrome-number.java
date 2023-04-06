class Solution {
    public boolean isPalindrome(int x) {
     int revnum=0;
     int orignalnum=x;
        while(x>0){
            int ld=x%10;
            revnum=(revnum*10)+ld;
            x=x/10;
        }
        return orignalnum==revnum;   
    }
}