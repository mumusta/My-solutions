class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0)
            return "";
        
        int end = 0, minima = (int) 1e6;

        for (int i = 0; i < strs.length; i ++)
            minima = Math.min(minima, strs[i].length());

        if (minima == 0)
            return "";

        for (int ii = 0; ii < minima; ii ++){

            boolean is = true;

            for (int i = 0; i < strs.length; i ++)
                is &= (strs[i].charAt(ii) == strs[0].charAt(ii));

            if (is) end++;
            else break;
        }

        return strs[0].substring(0, end);
    }
}
