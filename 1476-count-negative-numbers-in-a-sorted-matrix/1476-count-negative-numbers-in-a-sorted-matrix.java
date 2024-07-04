class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int m = grid[i].length;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
