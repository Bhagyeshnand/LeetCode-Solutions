class Solution {
    public int maximumLength(int[] arr, int K) {
        int dp[][] = new int[arr.length][K + 1];
        
        int prevmax[] = new int[arr.length]; // stores max previous dp value (for k - 1) starting from i to end
        for (int k = 0; k <= K; k++) {
            Map<Integer, Integer> same = new HashMap<>(); //stores [element => max dp value]
            int curmax[] = new int[arr.length]; //this is used to store max dp value (for k) starting from i to end, this will later be assigned to prevmax[]
            for (int i = arr.length - 1; i >= 0; i--) {

                //fetch from hash map
                dp[i][k] = Math.max(
                    1 + same.getOrDefault(arr[i], 0),
                    1 + ((i + 1 < arr.length) ? prevmax[i + 1] : 0)
                );
                
                //save to hash map
                final int curdp = dp[i][k];
                same.compute(arr[i], (key, val) -> {
                    if (val == null || val < curdp) return curdp;
                    else return val;
                });
                curmax[i] = Math.max(
                    i + 1 < curmax.length ? curmax[i + 1] : 0,
                    dp[i][k]
                );
            }
            prevmax = curmax;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            ans = Math.max(ans, dp[i][K]);
        return ans;
    }
}