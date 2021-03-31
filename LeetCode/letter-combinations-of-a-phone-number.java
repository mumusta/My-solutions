class Solution {
    
    public static char [][] h = new char[10][4];

    static {
        h[2][0] = 'a'; h[2][1] = 'b'; h[2][2] = 'c';
        h[3][0] = 'd'; h[3][1] = 'e'; h[3][2] = 'f';
        h[4][0] = 'g'; h[4][1] = 'h'; h[4][2] = 'i';
        h[5][0] = 'j'; h[5][1] = 'k'; h[5][2] = 'l';
        h[6][0] = 'm'; h[6][1] = 'n'; h[6][2] = 'o';
        h[7][0] = 'p'; h[7][1] = 'q'; h[7][2] = 'r'; h[7][3] = 's';
        h[8][0] = 't'; h[8][1] = 'u'; h[8][2] = 'v';
        h[9][0] = 'w'; h[9][1] = 'x'; h[9][2] = 'y'; h[9][3] = 'z'; }

    public List <String> res = new ArrayList <String>(); 
    public String d; int n;

    public void solve(StringBuilder str){

        int i = str.length();

        if (i == n){

            res.add(str.toString());
            return;
        }

        int curr = Character.getNumericValue(d.charAt(i));

        for (int x = 0; x < 4; x ++){

            if (h[curr][x] == '\u0000')
                break;

            StringBuilder t = new StringBuilder(str.toString());
            t.append(h[curr][x]); solve(t);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        d = digits; n = d.length();

        if (n > 0)
            solve(new StringBuilder(""));

        return res;
    }
}
