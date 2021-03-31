class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        long res = 0; boolean neg = false, started = false;

        for (int i = 0; i < s.length(); i ++){

            if ((s.charAt(i) == '-') || (s.charAt(i) == '+')){

                if (started) break;
                started = true;

                if (s.charAt(i) == '-') neg = true;

                continue;
            }

            if (Character.isDigit(s.charAt(i))){

                if (!started) started = true;
                res *= 10; res += Character.getNumericValue(s.charAt(i));

                if (neg){

                    if (res > Math.abs((long)Integer.MIN_VALUE))
                        break;
                }

                else {

                    if (res > Integer.MAX_VALUE)
                        break;
                }

                continue;
            }
            System.out.println("x");
            break;
        }

        if (neg) res *= -1;
        res = (res < Integer.MIN_VALUE) ? Integer.MIN_VALUE : res;
        res = (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE : res;
        return (int) res;
    }
}
