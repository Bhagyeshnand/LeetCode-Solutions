class Solution {
    public double champagneTower(int poured, int row, int col) {
        double[] dp = new double[col + 2];
        dp[0] = poured;
        for(int i = 0; i < row; i++) {
            for(int j = Math.min(i, col); j >= 0; j--) {
                if(dp[j] > 1) {
                    double val = (dp[j] - 1) / 2.0;
                    dp[j] = val;
                    dp[j + 1] += val;
                }else dp[j] = 0;
            }
        }
        return Math.min(1, dp[col]);
    }
}