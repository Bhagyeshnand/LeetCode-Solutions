class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0, lcm = 1;                    // Initialize count to track valid subarrays, lcm to store subarray LCM
        for (int i = 0; i < nums.length; i++) {    // Outer loop to set starting point of subarray
            lcm = 1;                               // Reset LCM for each new starting point
            for (int j = i; j < nums.length; j++) { // Inner loop to extend the subarray from i to j
                lcm = lcm(lcm, nums[j]);           // Calculate the LCM of the current subarray
                if (lcm == k) count++;             // If the LCM matches k, increment count
                else if (lcm > k) break;           // If LCM exceeds k, no need to extend further, break the loop
            }
        }
        return count;                              // Return the total count of subarrays whose LCM equals k
    }

    //calculate gcd of 2 numbers
    public static int gcd(int a, int b) {          // Helper method to compute GCD of two numbers
        return a == 0 ? b : gcd(b % a, a);         // Recursive GCD using Euclidean algorithm
    }

    //calculate lcm of 2 numbers
    public static int lcm(int a, int b) {          // Helper method to compute LCM of two numbers
        return (a * b) / gcd(a, b);                // LCM is calculated as (a * b) / GCD(a, b)
    }
}
