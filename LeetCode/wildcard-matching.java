class Solution {
    
    public int n, nn;
    public String s, p;
    public boolean [][]dp;
    public boolean [][]vis;

    boolean solve(int i, int ii){

        if ((i == n) && (ii == nn))
            return true;

        if (i == n){

            for (int x = ii; x < nn; x ++)
                if (p.charAt(x) != '*')
                    return false;

            return true;
        }

        if (ii == nn)
            return false;

        if (vis[i][ii])
            return dp[i][ii];

        vis[i][ii] = true;

        if (p.charAt(ii) == '*'){

            dp[i][ii] |= solve(i, ii + 1);
            dp[i][ii] |= solve(i + 1, ii);
        }

        else if (p.charAt(ii) == '?'){

            dp[i][ii] |= solve(i + 1, ii + 1);
        }

        else {

            if (s.charAt(i) == p.charAt(ii))
                dp[i][ii] |= solve(i + 1, ii + 1);
        }

        return dp[i][ii];
    }

    public boolean isMatch(String s_, String p_) {
        
        s = s_; p = p_; n = s.length(); nn = p.length();
        dp = new boolean[n + 1][nn + 1];
        vis = new boolean[n + 1][nn + 1];

        return solve(0, 0);
    }
}
