class Solution {

    private long[][] dp;
    private int k;
    private int n;
    private int mod = 1000000007;

    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[n+1][goal+1];
        this.k = k;
        this.n = n;
        for (int i = 0; i < n + 1; i ++) {
            Arrays.fill(dp[i], -1L);
        }
        return (int)(dp(n, goal) % mod);
    }

    private long dp(int g2, int goal) {
        if (goal == 0) {
            return 1;
        }
        if (dp[g2][goal] != -1L)  {
            return dp[g2][goal];
        }
        int g1 = Math.max(0, n - g2 - k);
        long res = 0L;
        // if pick from listened
        if (g1 != 0 && g2 < goal) {
            res += g1 * dp(g2, goal - 1);
            res = res % mod;
        }
        // if pick from not listened
        if (g2 != 0) {
            res += g2 * dp(g2 - 1, goal - 1);
            res = res % mod;
        }
        dp[g2][goal] = res;
        return res;
    }
}