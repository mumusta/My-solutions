class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start = 32, end = 126, res = 0;
        int [][]next = new int[256][s.length() + 1];

        for (int i = start; i <= end; i ++){

            next[i][s.length()] = (int)1e8;
            for (int ii = (s.length() - 1); ii >= 0; ii --){

                next[i][ii] = next[i][ii + 1];
                if (s.charAt(ii) == (char)i)
                    next[i][ii] = ii;
            }
        }

        for (int l = 0; l < s.length(); l ++){

            int r = Math.min(s.length() - 1, next[s.charAt(l)][l + 1] - 1);

            for (int i = start; i <= end; i ++){

                if (s.charAt(l) == (char)i)
                    continue;

                if (next[i][l] > r)
                    continue;

                else r = Math.min(r, next[i][next[i][l] + 1] - 1);
            }

            res = Math.max(res, (r - l) + 1);
        }

        return res;
    }
}
