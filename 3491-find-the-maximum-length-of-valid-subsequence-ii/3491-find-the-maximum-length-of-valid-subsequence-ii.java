class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return n;

        int res = 2;
        int[] modArr = new int[n];

        for (int i = 0; i < n; i++)
            modArr[i] = nums[i] % k;
        
        for (int j = 0; j < k; j++) {
            int[] dp = new int[k];
            for (int i = 0; i < n; i++) {
                int mod = modArr[i];
                int pos = (j - mod + k) % k;
                dp[mod] = dp[pos] + 1;
                res = Math.max(res, dp[mod]);
            }
        }
        return res;
    }
}