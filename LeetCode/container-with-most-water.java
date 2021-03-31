class Solution {
    public int maxArea(int[] height) {
        
        int i = 0, ii = height.length - 1, maxima = 0;

        while (i < ii){

            maxima = Math.max(maxima, (ii - i) * Math.min(height[i], height[ii]));
            if (height[i] <= height[ii])
                i ++;
            else ii --;
        }

        return maxima;
    }
}
