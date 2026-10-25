class Solution {
    private boolean dfs(int[][] grid,int r,int c){
        //out of bounds cond
        if(r<0 || c<0 || r>= grid.length || 
        c>=grid[0].length ) return false;
        if(grid[r][c]==1) return true;
        //if(grid[r][c]==1) return true;
        //visited cell marking 
        grid[r][c]=1;
        
        boolean up = dfs(grid,r-1,c);
        boolean down = dfs(grid, r+1, c);
        boolean left = dfs(grid, r, c-1);
        boolean right = dfs(grid, r, c+1);
        //check all four adj cells
        return  up && down && left && right;
    }

        
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int closedIsl = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        closedIsl++;
                    }
                }
            }
        }
        return closedIsl;
    }
}