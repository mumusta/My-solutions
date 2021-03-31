class Solution {
    public int reverse(int x) {
        
        boolean neg = (x < 0) ? true : false; 
        long res = 0; x = Math.abs(x);

        while (x > 0){

            res *= 10; 
            res += (x % 10); 
            x /= 10;
        }

        if (neg) res *= -1;

        if ((Integer.MIN_VALUE <= res) && (res <= Integer.MAX_VALUE))
            return (int)res;

        else return 0;
    }
}
