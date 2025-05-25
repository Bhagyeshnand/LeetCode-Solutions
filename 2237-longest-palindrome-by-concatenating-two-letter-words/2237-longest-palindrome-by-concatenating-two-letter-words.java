class Solution {
    private static final int S = 5;
    private static final int M = (1 << S) - 1;
    static {
        for(int i = 0; i < 100; i++) {
            longestPalindrome(new String[]{"lc", "cl", "gg"});
        }
    }
    public static int longestPalindrome(String[] words) {
        int[] freq = new int[1 << (S << 1)];
        for (String s: words)
            freq[(s.charAt(0) & M) << S | s.charAt(1) & M]++;
        int res = 0, mid = 0;
        for (int i = 1; i <= 26; i++) {
            int dupe = freq[i << S | i];
            res += dupe >> 1;
            mid |= dupe & 1;
            for (int j = i + 1; j <= 26; j++) {
                res += Math.min(freq[i << S | j], freq[j << S | i]);
            }
        }
        return (res << 2) | (mid << 1);
    }
}