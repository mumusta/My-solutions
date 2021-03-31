class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> seq = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i ++)
            seq.add(nums1[i]);

        for (int i = 0; i < nums2.length; i ++)
            seq.add(nums2[i]);

        Collections.sort(seq);

        if (seq.size() % 2 == 0) return ( (seq.get((seq.size() / 2) - 1) + 
                                           seq.get(seq.size() / 2)) / 2.0 );
        else return seq.get(seq.size() / 2);
    }
}
