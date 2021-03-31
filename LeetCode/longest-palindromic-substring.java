class Solution {
    public String longestPalindrome(String s) {
        
        int maxima, l_, r_; maxima = l_ = r_ = 0;

        for (int i = 0; i < s.length(); i ++){

            for (int l = i, r = i; (l >= 0) & (r < s.length()); l--, r++){

                if(s.charAt(l) != s.charAt(r))
                    break;

                if ((r - l + 1) > maxima){

                    maxima = (r - l + 1); 
                    l_ = l; r_ = r;
                }
            }

            for (int l = i, r = i + 1; (l >= 0) & (r < s.length()); l--, r++){

                if(s.charAt(l) != s.charAt(r))
                    break;

                if ((r - l + 1) > maxima){

                    maxima = (r - l + 1); 
                    l_ = l; r_ = r;
                }
            }
        }

        return s.substring(l_, r_ + 1);
    }
}
