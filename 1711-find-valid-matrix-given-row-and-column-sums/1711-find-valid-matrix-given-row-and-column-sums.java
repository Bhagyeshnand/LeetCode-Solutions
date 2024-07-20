class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
       int m = rowSum.length;
       int n = colSum.length;

       int[][] result = new int[m][n];
       int i = 0;
       int j = 0;

       while(i < m && j < n){
        result[i][j] = Math.min(rowSum[i], colSum[j]);
        rowSum[i] -= result[i][j];
        colSum[j] -= result[i][j];

        if(rowSum[i] == 0) i++;
        if(colSum[j] == 0) j++;
       } 

       return result;
    }
}