class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[] scoreAdd = {0, 1, 2};
        int[] costAdd = {0, 1, 1};

        // dp[i][j][c] = max score at (i, j) with cost c
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int c = 0; c <= k; c++)
                    dp[i][j][c] = -1;

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int costUsed = 0; costUsed <= k; costUsed++) {
                    if (dp[i][j][costUsed] == -1) continue;
                    int curScore = dp[i][j][costUsed];

                    // Move DOWN
                    if (i + 1 < m) {
                        int nc = costUsed + costAdd[grid[i+1][j]];
                        if (nc <= k) {
                            int ns = curScore + scoreAdd[grid[i+1][j]];
                            dp[i+1][j][nc] = Math.max(dp[i+1][j][nc], ns);
                        }
                    }

                    // Move RIGHT
                    if (j + 1 < n) {
                        int nc = costUsed + costAdd[grid[i][j+1]];
                        if (nc <= k) {
                            int ns = curScore + scoreAdd[grid[i][j+1]];
                            dp[i][j+1][nc] = Math.max(dp[i][j+1][nc], ns);
                        }
                    }
                }
            }
        }

        int best = -1;
        for (int c = 0; c <= k; c++) {
            best = Math.max(best, dp[m-1][n-1][c]);
        }
        return best;
    }
}