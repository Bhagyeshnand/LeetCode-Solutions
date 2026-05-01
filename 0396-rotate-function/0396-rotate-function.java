class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int curr = 0;

        // Calculate total sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            curr += i * nums[i];
        }

        int ans = curr;

        // Use relation to compute next rotations
        for (int i = 1; i < n; i++) {
            curr = curr - sum + n * nums[i - 1];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}