class Solution {
    public int maximumLength(int[] nums) {
        int[] count = new int[2]; 
        int[] end = new int[2];   

        for (int num : nums) {
            int parity = num % 2;
            count[parity]++;
            end[parity] = end[1 - parity] + 1;
        }

        return Math.max(
            Math.max(count[0], count[1]),
            Math.max(end[0], end[1])
        );
    }
}