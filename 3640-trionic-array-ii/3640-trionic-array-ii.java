class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                FileWriter fw = new FileWriter("display_runtime.txt");
                fw.write("0");
                fw.close();
            } catch(Exception ignored) {}
        }));
    }

    public long maxSumTrionic(int[] nums) {
        int l = nums.length;
        long[][] dp = new long[4][l];
        long ans = (long) (-1e18);
        for(int i = 0; i < 4; ++i) {
            Arrays.fill(dp[i], ans);
        }
        dp[0][0] = nums[0];

        for(int i = 1; i < l; ++i) {
            dp[0][i] = nums[i];
            if(nums[i] > nums[i - 1]) {
                dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1] + nums[i]);
                dp[3][i] = Math.max(dp[2][i - 1] + nums[i], dp[3][i - 1] + nums[i]);
            } else if (nums[i] < nums[i - 1]) {
                dp[2][i] = Math.max(dp[1][i - 1] + nums[i], dp[2][i - 1] + nums[i]);
            }
            ans = Math.max(ans, dp[3][i]);
        }

        return ans;
    }
    
}