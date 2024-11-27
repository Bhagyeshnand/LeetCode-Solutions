class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            if (i < n - 1) {
                adj[i].add(i + 1);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj[u].add(v);
            ans[i] = bfs(adj, n);
        }

        return ans;
    }

    private int bfs(List<Integer>[] adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, n);
        dist[0] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.offer(0);

        while (!que.isEmpty()) {
            int u = que.poll();

            for (int v : adj[u]) {
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] + 1;
                    que.offer(v);
                }
            }
        }

        return dist[n - 1];
    }
}