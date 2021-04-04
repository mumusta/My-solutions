class Solution {
    
    public int search(int[] nums, int target) {
        
        int start = 0, end = nums.length - 1, mid, last = nums[nums.length - 1];
        boolean isTargetFirst = (target > last) ? true : false;

        while (start < end){

            mid = (start + end) / 2;
            boolean isMidFirst = (nums[mid] > last) ? true : false;

            if (nums[mid] < target){

                if (isTargetFirst){

                    if (isMidFirst){

                        start = mid + 1;
                    }

                    else {

                        end = mid - 1;
                    }
                }

                else {

                    if (!isMidFirst){

                        start = mid + 1;
                    }
                }
            }

            else if (nums[mid] > target) {

                if (isTargetFirst){

                    if (isMidFirst){

                        end = mid - 1;
                    }
                }

                else {

                    if (isMidFirst){

                        start = mid + 1;
                    }

                    else {

                        end = mid - 1;
                    }
                }
            }

            else return mid;
        }

        if (nums[start] != target)
            return -1;

        return start;
    }
}
