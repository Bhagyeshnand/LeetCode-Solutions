class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1_000_000_007;
        int m = target.length();
        int n = words[0].length();
        
        // Frequency array: count[i][ch] is the frequency of character ch at index i in words
        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }

        // dp[j] represents the number of ways to form target[j:] from words
        long[] dp = new long[m + 1];
        dp[0] = 1; // Base case: 1 way to form an empty target
        
        for (int i = 0; i < n; i++) { // Iterate over columns in words
            for (int j = m - 1; j >= 0; j--) { // Traverse target in reverse
                char targetChar = target.charAt(j);
                dp[j + 1] = (dp[j + 1] + dp[j] * count[i][targetChar - 'a']) % mod;
            }
        }

        return (int) dp[m];
    }
}