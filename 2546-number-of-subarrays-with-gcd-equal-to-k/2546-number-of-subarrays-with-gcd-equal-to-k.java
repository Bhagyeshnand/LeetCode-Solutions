class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;                               // Initialize the answer (count of subarrays) to 0

        for (int i = 0; i < nums.length; i++) {    // Loop through the array to start subarrays
            int temp = nums[i];                    // Set 'temp' to the current number (start of the subarray)

            if (temp == k) ans++;                  // If the single element is equal to k, increment the count

            for (int j = i + 1; j < nums.length; j++) {  // Extend the subarray starting from index i
                if (nums[j] >= k) {                // Only proceed if the current number is greater than or equal to k
                    temp = gcd(nums[j], temp);     // Update 'temp' with the GCD of the subarray
                    if (temp == k) ans++;          // If the GCD of the subarray equals k, increment the count
                } else { 
                    break;                         // If a number less than k is found, stop extending the subarray
                }
            }
        }
        return ans;                                // Return the total count of subarrays with GCD equal to k
    }

    public static int gcd(int a, int b) {          // Helper function to calculate the GCD of two numbers
        return b == 0 ? a : gcd(b, a % b);         // Recursive GCD calculation using the Euclidean algorithm
    }
}
