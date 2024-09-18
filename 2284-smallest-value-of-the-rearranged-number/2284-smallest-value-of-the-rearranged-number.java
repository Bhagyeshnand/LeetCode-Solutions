class Solution {
    public long smallestNumber(long num) {

        if(num == 0) {  // If the input is zero, return zero immediately
            return 0;
        }

        long result = Math.abs(num);  // Take the absolute value of the number to work with positive digits
        int freq[] = new int[10];  // Frequency array to count occurrences of each digit (0-9)
        
        // Count the frequency of each digit in the number
        while(result > 0) {
            int temp = (int)(result % 10);  // Extract the last digit
            freq[temp]++;  // Increment the frequency of that digit
            result /= 10;  // Remove the last digit
        }

        if(num > 0) {  // For positive numbers
            int i = 1;  // Start at 1 because the smallest number can't start with zero
            int count_zero = freq[0];  // Count the number of zeros

            // Find the first non-zero digit
            while(freq[i] == 0) {
                i++;
            }

            result = (result * 10) + i;  // Start forming the result with the smallest non-zero digit
            freq[i]--;  // Decrease the frequency of that digit since it's used

            // Append all the zeros after the first non-zero digit
            while(count_zero-- > 0) {
                result = (result * 10);
            }

            // Append the remaining digits in increasing order
            while(i < 10) {
                while(freq[i] > 0) {
                    result = (result * 10) + i;  // Add the current digit to the result
                    freq[i]--;  // Decrease the frequency of the digit
                }
                i++;
            }

        } else {  // For negative numbers
            int i = 9;  // Start from the largest digit for negative numbers

            // Append digits in decreasing order to form the largest possible negative number
            while(i >= 0) {
                while(freq[i] > 0) {
                    result = (result * 10) + i;  // Add the current digit to the result
                    freq[i]--;  // Decrease the frequency of the digit
                }
                i--;
            }

            result *= -1;  // Negate the result to make it negative
        }

        return result;  // Return the final smallest or largest number based on the sign of the input
    }
}
