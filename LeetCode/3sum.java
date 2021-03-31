class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        
        Arrays.sort(nums);

        HashMap < Integer, Integer > hm = new HashMap < Integer, Integer >();
        
        for (int i = 0; i < nums.length; i ++)
            hm.put(nums[i], i);

        for (int i = 0; i < nums.length; i ++){

            if ((i > 0) && (nums[i] == nums[i - 1]))
                continue;

            for (int ii =  i + 1; ii < nums.length; ii ++){

                if ((ii != (i + 1)) && (nums[ii] == nums[ii - 1]))
                    continue;

                if (hm.containsKey((-1 * nums[i]) + (-1 * nums[ii]))){

                    int iii = hm.get((-1 * nums[i]) + (-1 * nums[ii]));

                    if (iii > ii){

                        ArrayList < Integer > tempo = new ArrayList<>();
                        tempo.add(nums[i]); 
                        tempo.add(nums[ii]); 
                        tempo.add(nums[iii]);
                        res.add(tempo);
                    }
                }
            }
        }

        return res;
    }
}
