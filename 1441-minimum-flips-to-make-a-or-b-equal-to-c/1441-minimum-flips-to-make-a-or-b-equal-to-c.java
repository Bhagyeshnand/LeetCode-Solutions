class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;                             // Initialize the number of flips to 0
        int or = a | b;                            // Perform a bitwise OR operation between a and b

        for (int i = 0; i < 32; i++) {             // Loop over all 32 bits (integers are 32-bit in Java)
            
            if ((or & (1 << i)) != (c & (1 << i))) {  // Check if the i-th bit of (a | b) differs from the i-th bit of c
                
                if ((or & (1 << i)) == 0) {        // If the i-th bit of (a | b) is 0 and needs to be 1 to match c
                    flips++;                       // Increment flips by 1
                } else {                           // If the i-th bit of (a | b) is 1 and needs to be 0 to match c
                    if ((a & (1 << i)) != 0)       // If the i-th bit of a is 1, it needs to be flipped
                        flips++;                   // Increment flips by 1
                    if ((b & (1 << i)) != 0)       // If the i-th bit of b is 1, it needs to be flipped
                        flips++;                   // Increment flips by 1
                }
            }
        }
        return flips;                              // Return the total number of flips needed
    }
}
