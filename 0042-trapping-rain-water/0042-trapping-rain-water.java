class Solution {
    public int trap(int[] height) {
          int n = height.length;

        //Calculate leftmax Boundary - Array
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        // Calculate rightmax Boundary - Array 
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
        //  waterlevel =  min(Leftmax Bound , rightmax Bound)   
            int waterlevel = Math.min(leftmax[i], rightmax[i]);

        // Trapped water = waterlevel - height of bar (height of Bar)
            trappedWater += waterlevel - height[i];
        }
          return trappedWater;
    }
}