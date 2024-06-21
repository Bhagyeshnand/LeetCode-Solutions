class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int total = 0, l = 0, r = 0, n = customers.length, curr = 0, max = 0;

        for( int i = 0; i<n; i++){ // Calculate non grumpy
            total += customers[i] * (1 - grumpy[i]);
        }

        for(; r < m; r++){ // 1st sliding window
            curr += customers[r] * grumpy[r];
        }
        max = curr;
        r = m;

        while( r<n ){ // Sliding our Window
            curr += customers[r] * grumpy[r++]; //add next element
            curr -= customers[l] * grumpy[l++]; //remove last element

            max = Math.max(max,curr); // update
        }

        return total + max; //total + max grumpy satisfaction
    }
}