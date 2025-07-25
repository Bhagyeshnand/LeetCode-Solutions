class Solution {
    public int maxSum(int[] nums) {
        // 1. Sort the nums array in ascending order.
        Arrays.sort(nums);

        // 2. Initialize the variables:
        // - sum: The current amount (starting with the largest element).
        int sum = nums[nums.length - 1];
        // - prev: The previous added element (starting with the largest element).
        int prev = sum;

        // 3. A loop running from the end of the array to the beginning, as long as two conditions are met:
        // a) i >= 0 (we do not go beyond the boundaries of the array).
        // b) nums[i] >= 0 (we continue only if the current element is >= 0).
        for (int i = nums.length - 2; i >= 0 && nums[i] >= 0; prev = nums[i], i--)
// 4. If the current element (nums[i]) differs from the previous one (prev),
// then add it to the amount.
            if (nums[i] != prev)
                sum += nums[i];

        // 5. We return the accumulated amount.
        return sum;
    }
}