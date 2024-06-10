class Solution {
    public int heightChecker(int[] heights) {
         int[] freq = new int[101];

        // Count the frequency of each height
        for (int height : heights) {
            freq[height]++;
        }

        int i = 0, j = 0, count = 0;
        
        // Iterate through each height from 1 to 100
        for (j = 1; j < 101; j++) {
            while (freq[j] > 0) {
                // If the current height in the sorted order (j) does not match the height in the input array
                if (heights[i] != j) {
                    count++;
                }
                // Move to the next height in the input array
                i++;
                // Decrement the frequency of the current height
                freq[j]--;
            }
        }
        return count;
    }
}