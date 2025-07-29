class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];

        for (int i = 0; i < n; ++i)
        {
            int x = nums[i];
            ans[i] = 1;
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; --j)
            {
                nums[j] |= x;
                ans[j] = i - j + 1;
            }
        }

        return ans;
    }
}