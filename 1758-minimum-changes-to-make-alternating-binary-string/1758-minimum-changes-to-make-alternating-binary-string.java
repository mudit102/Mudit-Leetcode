class Solution {
    public int minOperations(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
 
            // If there is 1 at even index positions
            if (i % 2 == 0 && s.charAt(i) == '1')
                ans++;
 
            // If there is 0 at odd index positions
            if (i % 2 == 1 && s.charAt(i) == '0')
                ans++;
        }
        return Math.min(ans, n - ans);
    }
}
