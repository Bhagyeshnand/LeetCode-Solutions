class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }


    public List<Integer> search(String s, int start) {
        List<Integer> matchLengths = new ArrayList<>();
        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                break;
            }
            node = node.children[index];
            if (node.isEndOfWord) {
                matchLengths.add(i - start + 1);
            }
        }
        return matchLengths;
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
         int n = s.length();
        Trie trie = new Trie();
        
        for (String word : dictionary) {
            trie.insert(word);
        }
        
        // DP array to store the minimum number of extra characters
        int[] dp = new int[n + 1];
        // Initialize with max possible extra characters
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // No valid way to get to this point
            
            // Get all possible matches starting at position i
            List<Integer> matchLengths = trie.search(s, i);
            
            // Try to update the dp array using the matched words
            for (int length : matchLengths) {
                dp[i + length] = Math.min(dp[i + length], dp[i]);
            }
            
            // Consider skipping this character (taking it as extra)
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        // The result is the minimum number of extra characters for the entire string
        return dp[n];
    }
}