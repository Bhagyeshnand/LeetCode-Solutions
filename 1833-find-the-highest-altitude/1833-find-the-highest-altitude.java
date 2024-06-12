class Solution {
    public int largestAltitude(int[] gain) {
        int max= 0, preSum = 0;

        for(int n : gain) {
            preSum += n;
            max = Math.max(max,preSum);
        }
        return max;
    }
}