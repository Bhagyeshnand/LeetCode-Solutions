class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        // If word has 2 or fewer letters, we can put each finger on a letter for free.
        if (n <= 2) return 0;
        
        // dp[j] = minimum total distance after typing up to the current letter,
        // with the idle finger at position j (0-25 for letters A-Z, 26 means not used yet).
        int[] dp = new int[27];
        for (int i = 0; i < 27; i++) dp[i] = Integer.MAX_VALUE;
        
        char[] w = word.toCharArray();
        // After typing the first two letters, we have two possibilities:
        // 1) One finger typed w[0], the other finger typed w[1] for free (cost 0 for second finger)
        //    but then the idle finger is at w[0]? Wait, careful: actually we set:
        // dp[26] = distance from w[1] to w[0]  (means: finger1 typed w[0], finger2 typed w[1] from free,
        //          then the idle finger is at w[1]? Let's read the code)
        // The original optimized solution sets:
        dp[26] = dist(w[1], w[0]);   // one finger on w[0], the other moved from free to w[1] paying distance
        dp[w[0] - 'A'] = 0;          // both fingers on w[0]? Actually: finger1 typed w[0] (free),
                                     // finger2 still free (26) but we store idle finger at w[0] with cost 0.
                                     // This means we consider that the second finger hasn't moved yet.
        
        // Now process the remaining letters from index 2 to n-1
        for (int i = 2; i < n; i++) {
            int delta = dist(w[i], w[i - 1]);   // cost if we move the finger that just typed the previous letter
            int best = dp[26];                  // start best with the case where idle finger is free
            
            // For every possible idle finger position j (0..26)
            for (int j = 0; j < 27; j++) {
                if (dp[j] < best) {
                    // If we use the other finger (the idle one) to type w[i],
                    // the cost is dp[j] + distance from j to w[i] (if j != 26, else 0).
                    int cost = (j == 26 ? 0 : dist(w[i], (char)(j + 'A')));
                    best = Math.min(best, dp[j] + cost);
                }
                // For the case where we move the finger that was on the previous letter,
                // we simply add delta to every dp[j] (because the idle finger stays where it was).
                if (dp[j] < Integer.MAX_VALUE) dp[j] += delta;
            }
            // Now dp[] contains costs after adding delta (move previous finger).
            // But we also have a new possibility: the other finger (the one we just moved)
            // becomes idle at position w[i-1]. So we update dp[w[i-1]-'A'] with the best
            // value we computed (which corresponds to using the idle finger for the new letter).
            dp[w[i - 1] - 'A'] = Math.min(dp[w[i - 1] - 'A'], best);
        }
        
        // After processing all letters, the answer is the smallest total cost
        // among all possible idle finger positions.
        int res = Integer.MAX_VALUE;
        for (int v : dp) res = Math.min(res, v);
        return res;
    }
    
    // Manhattan distance between two letters on a standard 6-column keyboard layout.
    private int dist(char a, char b) {
        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}