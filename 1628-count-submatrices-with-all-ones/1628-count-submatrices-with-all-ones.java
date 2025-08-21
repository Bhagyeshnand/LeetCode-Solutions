class Solution {
    public int numSubmat(int[][] mat) {

         int n = mat.length;
        int m = mat[0].length;

        int ans = 0;
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            // Update histogram heights
            for (int j = 0; j < m; j++) {
                height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
            }

            // Count rectangles in current histogram
            ans += countRectangles(height);
        }

        return ans;
    }


    private int countRectangles(int[] height) {
        int m = height.length;
        int count = 0;
        int[] stack = new int[m];
        int top = -1;
        int[] sum = new int[m];

        for (int j = 0; j < m; j++) {
            while (top >= 0 && height[stack[top]] >= height[j]) {
                top--;
            }

            if (top == -1) {
                sum[j] = height[j] * (j + 1);
            } else {
                sum[j] = sum[stack[top]] + height[j] * (j - stack[top]);
            }

            count += sum[j];
            stack[++top] = j;
        }

        return count;
    }
}