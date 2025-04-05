class Solution {
    public int subsetXORSum(int[] nums) {
        // First create helper function, this function will help us to calculate
        // when i'm including, when i'm not. The XOR of that array
        return helper(nums, 0, 0); // nums, level, current XOR
    }
    public int helper(int nums[], int level, int currentXOR){
        // base condition
        if(level == nums.length) return currentXOR;
        // creating include 
        int include = helper(nums, level + 1, currentXOR^nums[level]);
        // creating exclude
        int exclude = helper(nums, level + 1, currentXOR);
        
        return include + exclude;
    }
}