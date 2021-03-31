class Solution {
    
    public List <String> res = new ArrayList <String>(); int n;

    public void solve(int bal, int s, StringBuilder str){

        int len = str.length();

        if (len == n * 2){

            //if (bal == 0 && s == n){

                res.add(str.toString());
            //}
            return;
        }

        if (s < n){

            StringBuilder t = new StringBuilder(str.toString());
            t.append('('); solve(bal + 1, s + 1, t);
        }

        if (bal > 0){ 

            StringBuilder t = new StringBuilder(str.toString());
            t.append(')'); solve(bal - 1, s, t);
        }
    }

    public List<String> generateParenthesis(int n) {
        
        this.n = n;
        solve(0, 0, new StringBuilder(""));
        return res;
    }
}
