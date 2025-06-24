class Solution {
    public int numSpecial(int[][] mat) {
        int special = 0;

        for (int[] row : mat) {
            if (getRowSum(row) == 1) {
                int colIdx = getIndexOfOne(row);
                special += (getColumnSum(mat, colIdx) == 1) ? 1 : 0;
            }
        }

        return special;        
    }

    private int getRowSum(int[] row) {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        return sum;
    }

    private int getColumnSum(int[][] mat, int colIdx) {
        int sum = 0;
        for (int[] row : mat) {
            sum += row[colIdx];
        }
        return sum;
    }

    private int getIndexOfOne(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                return i;
            }
        }
        return -1; // If 1 is not found, return -1 or handle accordingly
    }    
}