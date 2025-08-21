class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] table = new int[101];
        for(int n: nums) ++table[n];
        int count = 0;
        for(int i = k+1; i<=100;i++)
            count += table[i] * table[i-k];
        return count;
        // int pair = 0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     for(int j=0;j<nums.length;j++)
        //     {
        //         if(i<j && Math.abs(nums[i] - nums[j]) == k )
        //         {
        //             pair++;
        //         }
        //     }
        // }
        // return pair;
    }
}
    