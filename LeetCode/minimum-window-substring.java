class Solution {
    
    public static String minWindow(String s, String t) {
        
        int found[] = new int[125];
        StringBuilder str = new StringBuilder();
        ArrayList < Integer > in = new ArrayList < Integer > ();

        for (int i = 0; i < t.length(); i ++)
            found[t.charAt(i)] ++;

        for (int i = 0; i < s.length(); i ++){

            if (found[s.charAt(i)] > 0){
                
                str.append(s.charAt(i)); 
                in.add(i);
            }
        }

        if (str.length() == 0)
            return "";

        int cw[] = new int[125]; cw[str.charAt(0)]++; int n = str.length();
        int l = 0, r = 0, minima = (int)1e6, start = 0, end = 0;

        while (true){
            
            boolean is = true;

            for (int i = 0; i < 125; i ++)
                is &= (cw[i] >= found[i]);

            if (is){
                
                if (((in.get(r) - in.get(l)) + 1) < minima){

                    minima = ((in.get(r) - in.get(l)) + 1);
                    start = in.get(l); end = in.get(r);
                }

                if ((r - l) >= 1){
                    
                    cw[str.charAt(l)]--;
                    l++;
                }

                else {

                    if (r == (n - 1))
                        break;
                    
                    cw[str.charAt(l)]--;
                    l++;
                    r++;
                    cw[str.charAt(r)]++;
                }
            }

            else {
                
                if (r == (n - 1))
                    break;
                    
                r++;
                cw[str.charAt(r)]++;
            }
        }

        if (minima == (int)1e6) return "";
        else return s.substring(start, end + 1);
    }
}
