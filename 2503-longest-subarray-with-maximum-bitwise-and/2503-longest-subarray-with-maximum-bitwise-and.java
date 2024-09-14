class Solution {
    public int longestSubarray(int[] nums) {
        int len = 1;

        // Step 1: Find the maximum element in the array
        int mx = Integer.MIN_VALUE;
        for (int num : nums) mx = Math.max(mx, num);  // O(n)

        // Step 2: Find the longest subarray consisting of the maximum element
        int tmp_len = 0;
        for (int num : nums) {  // O(n)
            if (num == mx) {
                tmp_len++;
            } else {
                len = Math.max(len, tmp_len);
                tmp_len = 0;
            }
        }

        // Update len in case the longest subarray is at the end
        len = Math.max(len, tmp_len);

        return len;
    }
}