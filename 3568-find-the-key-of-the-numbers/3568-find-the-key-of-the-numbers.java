class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, p = 1;            // Initialize ans for the result and p as a place value multiplier
        
        for (int i = 0; i < 4; i++) {    // Loop to ext ract and compare the last 4 digits of each number
            int t = Math.min(num1 % 10, num2 % 10);  // Get the last digit of num1 and num2 and find the minimum
            t = Math.min(t, num3 % 10);  // Compare with the last digit of num3 and find the smallest digit
            
            ans += t * p;        // Add the smallest digit to the result with the correct place value
            num1 /= 10;          // Remove the last digit of num1
            num2 /= 10;          // Remove the last digit of num2
            num3 /= 10;          // Remove the last digit of num3
            p *= 10;             // Increase the place value multiplier (units -> tens -> hundreds -> thousands)
        }
        
        return ans;  // Return the generated key
    }
}
