class Solution {
    public int countSquares(int[][] matrix) {
        int rowSize  = matrix.length;
        int colSize = matrix[0].length;
        int total = 0;

        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                if(matrix[i][j] == 1 && i != 0 && j != 0 )
                  {  matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));}
                total += matrix[i][j];
            }
        }
        return total;
    }
}