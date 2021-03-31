class Solution {
    
    public int[] plusOne(int[] digits) {
    
        boolean carry = true;

        for (int i = (digits.length - 1); i >= 0; i --){

            if (carry){

                digits[i] ++;

                if (digits[i] > 9){

                    digits[i] = 0;
                }

                else {

                    carry = false;
                }
            }

            else break;
        }

        if (!carry)
            return digits;

        int []res = new int[digits.length + 1]; res[0] = 1;

        for (int i = 0; i < digits.length; i ++)
            res[i + 1] = digits[i];

        return res;
    }
}
