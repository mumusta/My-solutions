class Solution {
    
    String solve(String s){

        StringBuilder res = new StringBuilder();
        char curr = s.charAt(0); int cw = 0;

        for (int i = 0; i < s.length(); i ++){

            if (s.charAt(i) == curr)
                cw++;

            else {

                res.append(String.valueOf(cw));
                res.append(curr);
                cw = 1; curr = s.charAt(i);
            }
        }

        if (cw > 0){

            res.append(String.valueOf(cw));
            res.append(curr);
        }

        return res.toString();
    }

    public String countAndSay(int n) {
     
        String res = "1";

        if (n == 1)
            return res;

        for (int x = 1; x < n; x ++)
            res = solve(res);

        return res;
    }
}
