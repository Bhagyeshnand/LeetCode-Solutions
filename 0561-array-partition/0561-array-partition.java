class Solution {
    public int arrayPairSum(int[] nums) {
        // Sort the array in non-decreasing order
        Arrays.sort(nums);
        int sum = 0;
        // Iterate through the sorted array and sum every alternate element
        for(int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }
}