// Appraoch 3 (Best Approach) /* By noticing the Sorted array, Binary Search 
// Comes into play but , the implementation is a little different in 2d matrix
// case so if it is known beforehand then only it strikes*/

// Time Complexity:O(N) //N== n^2
// Auxiliary Space Complexity: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;
           
            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid) c--;   
                
                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]); 
         // mid might be value not in  matrix, we need to record the actually max num;
                }else{ //it means c < 0
                    break;
                } 
            }
            
            // adjust search range
            if (count == k) return maxNum;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

}
//This Approach Code taken from : https://leetcode.com/meganlee/