class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n < 3 || m < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for (int i = 0; i < 3; i++) {
            if (grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != sum) {
                return false;
            }
            if (grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != sum) {
                return false;
            }
        }
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != sum) {
            return false;
        }
        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum) {
            return false;
        }
        return true;
    }
}
