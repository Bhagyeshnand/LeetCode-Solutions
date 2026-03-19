class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] colX = new int[n];
        int[] colY = new int[n];
        int ans = 0;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 'X') colX[j]++;
                if(grid[i][j] == 'Y') colY[j]++;
            }
            
            int x = 0, y = 0;
            for(int j = 0; j < n; j++) {

                x += colX[j];
                y += colY[j];

                if(x == y && x > 0) ans++;
            }
        }

        return ans;
    }
}