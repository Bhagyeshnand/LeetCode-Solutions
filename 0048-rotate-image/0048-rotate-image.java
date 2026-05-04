class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i =0 ; i<n/2;i++) {
            for(int j=i; j<n-i-1;j++) {
                //Swap the values of four elements (top, right, bottom, left)
                //within each layer to perform the 90-degree clockwise rotation.
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }            
        }
    }
}

// class Solution {
//     public void rotate(int[][] matrix) {
//      //transpose
//        for(int i=0; i<matrix.length; i++) {
//             for(int j=i; j<matrix[0].length; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         } // reverse column
//              for(int r=0; r<matrix.length; r++) {
//             int left = 0;
//             int right = matrix.length-1;

//             while(left < right) {
//                 int temp = matrix[r][left];
//                 matrix[r][left] = matrix[r][right];
//                 matrix[r][right] = temp;

//                 left++;
//                 right--;
//             }
//     }
// }
// }