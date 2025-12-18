class Solution {
    private static final int MAX_SIZE = 100001;
    private static long[] prefixSum = new long[MAX_SIZE];
    
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length, half = k / 2;
        Arrays.fill(prefixSum, 0, n + 1, 0);
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long) strategy[i] * prices[i];
        }
        
        long windowSum = 0;
        for (int i = half; i < k; i++) {
            windowSum += prices[i];
        }
        long maxProfit = Math.max(prefixSum[n], windowSum + prefixSum[n] - prefixSum[k]);
        
        for (int start = 1; start + k <= n; start++) {
            windowSum += prices[start + k - 1] - prices[start + half - 1];
            maxProfit = Math.max(maxProfit, windowSum + prefixSum[n] - prefixSum[start + k] + prefixSum[start]);
        }
        
        return maxProfit;
    }
}