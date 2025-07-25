class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[nums.length - 1];
        int sum = prev;
        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            if (n <= 0) {
                return sum;
            } else if (n != prev) {
                sum = sum + n;
            }
            prev = n;
        }
        return sum;
    }
}