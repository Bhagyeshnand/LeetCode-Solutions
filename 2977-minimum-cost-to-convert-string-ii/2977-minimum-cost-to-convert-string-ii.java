class Solution {
    private int index = 0;
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        TrieNode root = new TrieNode();
        for(String s : original) insert(s, root);
        for(String s : changed) insert(s, root);
        int[][] dist = new int[index][index];
        for(int i = 0; i < index; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i = 0; i < cost.length; i++) {
            int x = getIndex(original[i], root), y = getIndex(changed[i], root);
            if(cost[i] < dist[x][y]) dist[x][y] = cost[i];
        }
        for(int i = 0; i < index; i++) {
            for(int j = 0; j < index; j++) {
                if(dist[j][i] != Integer.MAX_VALUE) {
                    for(int k = 0; k < index; k++) {
                        if(dist[i][k] != Integer.MAX_VALUE && dist[j][i] + dist[i][k] < dist[j][k]) dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
        char[] arr1 = source.toCharArray(), arr2 = target.toCharArray();
        int n = arr1.length;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == Long.MAX_VALUE) continue;
            TrieNode node1 = root, node2 = root;
            if(arr1[i] == arr2[i] && dp[i] < dp[i + 1]) dp[i + 1] = dp[i];
            for(int j = i; j < n; j++) {
                node1 = node1.next[arr1[j] - 'a'];
                node2 = node2.next[arr2[j] - 'a'];
                if(node1 == null || node2 == null) break;
                if(node1.index != -1 && node2.index != -1 && dist[node1.index][node2.index] != Integer.MAX_VALUE && dist[node1.index][node2.index] + dp[i] < dp[j + 1]) dp[j + 1] = dist[node1.index][node2.index] + dp[i];
            }
        }
        return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
    }
    private void insert(String s, TrieNode root) {
        for(int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            if(root.next[current] == null) root.next[current] = new TrieNode();
            root = root.next[current];
        }
        if(root.index == -1) root.index = index++;
    }
    private int getIndex(String s, TrieNode root) {
        for(int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            root = root.next[current];
        }
        return root.index;
    }
}
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int index = -1;
}