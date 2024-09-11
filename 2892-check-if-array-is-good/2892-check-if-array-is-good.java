class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;                    // Set n to be the last index (nums length minus 1)

        int[] arr = new int[nums.length];           // Create an array 'arr' to count occurrences of each number
        for (int i = 0; i < nums.length; i++) {     // Loop through each element in the input array 'nums'
            if (nums[i] > n) return false;          // If any number in 'nums' is greater than n, return false
            else arr[nums[i]]++;                    // Otherwise, increment the count for that number in 'arr'
        }
        
        for (int i = 1; i < n; i++) {               // Loop from 1 to n-1 (all numbers except the last one)
            if (arr[i] != 1) return false;          // If any number appears more or less than once, return false
        }
        if (arr[n] != 2) return false;              // The number n should appear exactly twice, otherwise return false

        return true;                                // If all conditions are met, return true
    }
}
