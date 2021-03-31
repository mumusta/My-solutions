class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int halfs = 0, l = 0, r = 0;
        boolean isEven = (target % 2 == 0)? true : false;

        HashMap <Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i ++){

            hm.put(nums[i], i);

            if (isEven && (nums[i] == (target / 2))){
                halfs++; l = r; r = i;
            }
        }

        if (halfs > 1)
            return new int[] { l, r };
        
        for (int i = 0; i < nums.length; i ++){
            int n = nums[i];
            if (hm.containsKey(target - n) && hm.get(target - n) != i)
                return new int[] { i, hm.get(target - n) };
        }
        
        return new int[] { 0, 0 };
    }       
}

