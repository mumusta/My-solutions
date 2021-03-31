class Solution {
    
    public boolean []star;
    public String pat, str;
    public boolean [][]dp = new boolean[33][33];
    public boolean [][]dpi = new boolean[33][33];

    public boolean solve(int i, int ii){
        
        if ((i == pat.length()) && (ii == str.length()))
            return true;

        if (i == pat.length())
            return false;

        if (ii == str.length()){

            boolean res = true;

            for (int x = i; x < pat.length(); x ++)
                res &= star[x];

            return res;
        }

        if (dpi[i][ii]) return dp[i][ii];

        dpi[i][ii] = true;

        boolean ret = false;
        
        if (star[i]){

            ret |= solve(i + 1, ii);

            if (pat.charAt(i) == '.')
                ret |= solve(i, ii + 1);

            else {

                if (pat.charAt(i) == str.charAt(ii))
                    ret |= solve(i, ii + 1);
            }
        }

        else {

            if (pat.charAt(i) == '.')
                ret |= solve(i + 1, ii + 1);

            else {

                if (pat.charAt(i) == str.charAt(ii))
                    ret |= solve(i + 1, ii + 1);
            }
        }

        dp[i][ii] = ret;

        return ret;
    }
    
    public boolean isMatch(String s, String p) {
        
        char curr = '@';
        StringBuilder t = new StringBuilder(); 
        boolean []is = new boolean[33];

        for (int i = 0; i < p.length(); i ++){

            if (p.charAt(i) == '*'){

                t.append(curr);
                is[t.length() - 1] = true;
                curr = '@';
            }

            else {

                if (curr != '@'){

                    t.append(curr);
                }

                curr = p.charAt(i);
            }
        }

        if (curr != '@'){

            t.append(curr);
        }

        p = t.toString();

        str = s; pat = p; star = is;

        return solve(0, 0);
    }
}
