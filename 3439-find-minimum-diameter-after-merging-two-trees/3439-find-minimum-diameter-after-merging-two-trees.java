class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for(int i = 0; i < m; i++) adj2.add(new ArrayList<>());

        // Create Adjacency Lists
        for(int[] i : edges1) {
            adj1.get(i[0]).add(i[1]);
            adj1.get(i[1]).add(i[0]);
        }
        for(int[] i : edges2) {
            adj2.get(i[0]).add(i[1]);
            adj2.get(i[1]).add(i[0]);
        }

        // Find Longest Diameter In Tree 1
        boolean[] vis1 = new boolean[n];
        int[] ans1 = fun(adj1, vis1, 0);
        vis1 = new boolean[n];
        ans1 = fun(adj1, vis1, ans1[0]);
        
        // Find Longest Diameter In Tree 2
        boolean[] vis2 = new boolean[m];
        int[] ans2 = fun(adj2, vis2, 0);
        vis2 = new boolean[m];
        ans2 = fun(adj2, vis2, ans2[0]);

        // Find Maximum Diameter Between Tree1 and Tree2
        int maxDiam = Math.max(ans1[1], ans2[1]);

        // Find Diameter In Combined Tree
        int combineMax = (ans1[1] + 1) / 2 + (ans2[1] + 1) / 2 + 1;

        // Return Maximum Of Both
        return Math.max(maxDiam, combineMax);
    }
    // Return {LastNode, Diameter}
    static int[] fun(List<List<Integer>> adj, boolean[] vis, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        int len = 0;
        int last = node;
        while(!q.isEmpty()) {
            int size = q.size();
            len++;
            for(int i = 0; i < size; i++) {
                int temp = q.poll();
                last = temp;
                vis[temp] = true;
                for(int j : adj.get(temp)) {
                    if(!vis[j]) q.add(j);
                }
            }
        }
        return new int[]{last, len - 1};
    }
}