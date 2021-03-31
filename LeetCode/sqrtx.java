class Solution {
    
    public int mySqrt(int x) {
        
        if (x == 0)
            return 0;

        double start = 1, end = Integer.MAX_VALUE, mid = 0;

        for (int z = 0; z < 100; z ++){

            mid = (start + end) / 2.0;
            if ((mid * mid) < (double)x) start = mid;
            else end = mid;
        }
        
        return (int)mid;
    }
}
