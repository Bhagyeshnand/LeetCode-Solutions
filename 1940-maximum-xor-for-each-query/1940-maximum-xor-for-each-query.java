public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxVal = (1 << maximumBit) - 1;  // Maximum possible value with `maximumBit` bits
        int[] result = new int[n];
        int xor = 0;
        
        // Compute the prefix XOR for the entire array
        for (int num : nums) {
            xor ^= num;
        }
        
        // Process each query in reverse order
        for (int i = 0; i < n; i++) {
            result[i] = xor ^ maxVal;  // Maximum XOR for the current prefix
            xor ^= nums[n - 1 - i];    // Remove the last element's effect for the next query
        }
        
        return result;
    }
}