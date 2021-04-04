class Solution {
    
    public int trap(int[] height) {
     
        int maxima = -1, index = 0, n = height.length, res = 0;

        for (int i = 0; i < n; i ++){

            if (height[i] > maxima){

                maxima = height[i];
                index = i;
            }
        }

        maxima = -1;

        for (int i = 0; i < index; i ++){

            if (height[i] > maxima){

                maxima = height[i];
                continue;
            }

            res += (maxima - height[i]);
        }

        maxima = -1;

        for (int i = (n - 1); i > index; i --){

            if (height[i] > maxima){

                maxima = height[i];
                continue;
            }

            res += (maxima - height[i]);
        }

        return res;
    }
}
