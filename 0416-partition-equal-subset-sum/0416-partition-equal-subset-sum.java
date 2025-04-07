class Solution {

    // private boolean solve(int idx, int k, int[] nums, int[][] dp){
    //     if (k == 0)
    //         return true;

    //     if (idx == 0)
    //         return nums[0] == k;

    //     if (dp[idx][k] != -1)
    //         return dp[idx][k] == 0 ? false : true;

    //     boolean notTaken = solve(idx - 1, k, nums, dp);

    //     boolean taken = false;

    //     if (nums[idx] <= k)
    //         taken = solve(idx - 1, k - nums[idx], nums, dp);

    //     dp[idx][k] = notTaken || taken ? 1 : 0;
    //     return notTaken || taken;
    // }

    Boolean canPartition(Boolean[] memo, int s, int index, int[] nums) {
        if (s == 0)
            return true;

        if (s < 0)
            return false;
       
        if (index == 0)
            return s == nums[0];
       
        if (memo[s] != null)
            return memo[s];
       
        return memo[s] = canPartition(memo, s - nums[index], index - 1, nums) || canPartition(memo, s, index - 1, nums);
    }

    public boolean canPartition(int[] nums) {

        int s = 0;

        for (int i = 0; i < nums.length; i++)
            s += nums[i];

        if (s % 2 != 0)
            return false;

        int n = nums.length;

        s /= 2;

        Boolean[] memo = new Boolean[s + 1];

        return canPartition(memo, s, n - 1, nums);

        // int sum = 0;
        // int n = nums.length;

        // for(int i : nums){
        //     sum += i;
        // }

        // if(sum % 2 == 1){
        //     return false;
        // }else{
        //     int k = sum / 2;

        //     int dp[][] = new int[n][k + 1];

        //     for (int row[] : dp)
        //         Arrays.fill(row, -1);

        //     return solve(n - 1, k, nums, dp);
        // }

    }
}