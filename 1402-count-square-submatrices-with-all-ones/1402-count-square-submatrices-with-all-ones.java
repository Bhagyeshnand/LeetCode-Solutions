class Solution {

    static {
        int[][] matrix = new int[][]{{0,1,0,1,1,0}, {1,0,0,1,1,1}, {1,1,0,0,0,1}, {1,0,0,1,1,1}};
        for (int i=0;i< 500;i++)
        countSquares(matrix);
    }

    public static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int count =0;
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                    count += matrix[i][j];
                }
            }
        }
        for (int i=0;i<m;i++) {
            count+=matrix[i][0];
        }

        for (int i=1;i<n;i++) {
            count+=matrix[0][i];
        }
        return count;
        
    }
}