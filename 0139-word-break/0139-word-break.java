import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new Boolean[s.length()]);
    }

    boolean helper(String s, List<String> wordDict, int index, Boolean[] memo) {
        if (index == s.length()) return true;

        if (memo[index] != null) return memo[index];

        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                if (helper(s, wordDict, index + word.length(), memo)) {
                    return memo[index] = true; // Store the result in the memo array
                }
            }
        }

        return memo[index] = false;
    }
}