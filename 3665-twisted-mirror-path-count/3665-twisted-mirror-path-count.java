class Solution {
    public int uniquePaths(int[][] grid) {
        int m = 1_000_000_007;
        int n = grid[0].length;
        int[] r = new int[n + 1];
        int[] d = new int[n + 1];
        r[0] = 1;

        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    int c = (d[j + 1] + r[j]) % m;
                    d[j + 1] = c;
                    r[j + 1] = c;
                } else {
                    r[j + 1] = d[j + 1];
                    d[j + 1] = r[j];
                }
            }
            r[0] = 0;
        }
        return r[n];
    }
}