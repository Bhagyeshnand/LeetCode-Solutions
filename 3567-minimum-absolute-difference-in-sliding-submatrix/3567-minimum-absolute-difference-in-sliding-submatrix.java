class Solution {
    public int getmn(int[] arr){
        Arrays.sort(arr);
        int mn = Integer.MAX_VALUE;
        for(int i = 1;i< arr.length;i++){
            if(arr[i - 1] != arr[i]){
                mn = Math.min(mn, Math.abs(arr[i] - arr[i - 1]));
            }
            
        }
        return mn == Integer.MAX_VALUE? 0:mn;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        // 1 1 1
        // 1 1 1
        // 1 1 1
        int m = grid.length, n = grid[0].length;
        int[][] answ = new int[m - k + 1][n - k + 1];
        for(int row = 0; row < m - k + 1;row++){
            for(int col = 0; col < n - k + 1;col++){
                int[] arr = new int[k * k];
                int idx = 0;
                for(int i = row;i < row + k;i++){
                    for(int j = col;j < col + k;j++){
                        arr[idx] = grid[i][j];
                        idx++;
                    }
                }
                answ[row][col] = getmn(arr);
                

            }
        }
        return answ;
    }
}