class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long count = 0;
        int MOD = (int) 1e9 + 7, MAX_VAL = 100001;
        
        int[] left_count = new int[2 * MAX_VAL], right_count = new int[2 * MAX_VAL];
        for (int num : nums) right_count[num]++;
        
        for (int j = 0; j < n; j++) {
            int num_j = nums[j];
            right_count[num_j]--;
            
            int target = num_j * 2;
            if (target <= 2 * MAX_VAL) {
                count += (long) left_count[target] * right_count[target];
            }
            
            left_count[num_j]++;
        }
        
        return (int) (count % MOD);
    }
}