class Solution {
    public int minBitFlips(int start, int goal) {
       int count = 0; 
        int xor = start ^ goal; // XOR will give 1 where the bits differ

        while(xor!=0){
            count += xor & 1; // Increment count if the last bit is 1
            xor >>=1; // Right-shift to check the next bit
        }
        return count;
    }
}

/*
Approach

1.XOR the two numbers: Perform a bitwise XOR between start and goal. 
The result will have 1 in positions where the bits are different between 
the two numbers.

2.Count the number of 1s in the XOR result: This tells us the number
of positions where the bits differ and hence the number of bit flips required.

3.Bit counting: Use a loop to repeatedly check the last bit of the XOR
result using & 1. Right shift the XOR result (>> 1) to process the next bit.
Continue until all bits are processed.
*/