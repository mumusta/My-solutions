class Solution {
    
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0)
            return new int[]{ -1, -1 };
        
        int []res = new int[2];
        int start = 0, end = nums.length - 1, mid = 0;

        while (start < end){

            mid = (start + end) / 2;

            if (nums[mid] < target)
                start = mid + 1;

            else end = mid;
        }

        if (nums[start] != target)
            return new int[]{ -1, -1 };

        res[0] = start;

        start = 0; end = nums.length - 1;

        while (start < end){

            mid = (start + end) / 2; mid++;

            if (nums[mid] <= target)
                start = mid;

            else end = mid - 1;
        }

        res[1] = start;

        return res;
    }
}
