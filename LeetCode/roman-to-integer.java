class Solution {
    public int romanToInt(String s) {
        
        int ret = 0;

        HashMap <Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1); hm.put('V', 5); hm.put('X', 10);
        hm.put('L', 50); hm.put('C', 100); hm.put('D', 500); hm.put('M', 1000);

        for (int i = 0; i < s.length(); i ++){

            if (i == (s.length() - 1)){
                ret += hm.get(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == 'I'){

                if (s.charAt(i + 1) == 'V')
                    {ret += 4; i++;}

                else if (s.charAt(i + 1) == 'X') 
                    {ret += 9; i++;}

                else ret += hm.get(s.charAt(i));

                continue;
            }

            if (s.charAt(i) == 'X'){
                
                if (s.charAt(i + 1) == 'L')
                    {ret += 40; i++;}

                else if (s.charAt(i + 1) == 'C') 
                    {ret += 90; i++;}

                else ret += hm.get(s.charAt(i));

                continue;
            }

            if (s.charAt(i) == 'C'){

                if (s.charAt(i + 1) == 'D')
                    {ret += 400; i++;}

                else if (s.charAt(i + 1) == 'M') 
                    {ret += 900; i++;}

                else ret += hm.get(s.charAt(i));

                continue;
            }

            ret += hm.get(s.charAt(i));
        }

        return ret;
    }
}
