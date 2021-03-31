class Solution {
    
    public static int []dp = new int [46];

    static {

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= 45; i ++)
            dp[i] += dp[i - 1] + dp[i - 2];
    }

    public int climbStairs(int n) {
        
        return dp[n];
    }
}
