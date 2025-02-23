class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int v = isConnected.length;
        boolean vis[] = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                bfs(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }
    public void bfs(int adj[][], int s, boolean vis[]){
        // if(vis[s]){
        //     return;
        // }
        vis[s] = true;
        for(int v = 0; v < adj.length; v++){
            int u = adj[s][v];
            if(u == 1 && !vis[v]){
                bfs(adj, v, vis);
                vis[v] = true;
            }
        }
    }
}