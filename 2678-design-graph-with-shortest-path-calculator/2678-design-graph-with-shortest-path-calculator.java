class Graph {
    int[][] dist;
    int n;
    int MAX = Integer.MAX_VALUE / 3;

    public void floyd()
    {
        for (int k = 0; k < n; ++k) // 枚举中间点， 其中初始点即为矩阵图，注意需要把g[i][i]写成0
        {
            for (int i = 0; i < n; ++i) //  枚举起始点
            {
                for (int j = 0; j < n; ++j) // 枚举终点
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // 不断更新，直到所有点都被枚举为中间点一次
                }
            }
        }
    }

    public Graph(int n, int[][] edges) {
        dist = new int[n][n];
        for (int i = 0; i < n; ++i)
        {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
            

        for (int[] e : edges)
            dist[e[0]][e[1]] = e[2];
        this.n = n;
        floyd();
    }
    
    public void addEdge(int[] edge) {
        if (dist[edge[0]][edge[1]] <= edge[2])
        {
            return;
        }

        int x = edge[0], y = edge[1], w = edge[2];
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                dist[i][j] = Math.min(dist[i][j], dist[i][x] + w + dist[y][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        int[][] c = this.dist;
        return dist[node1][node2] == MAX ? -1 : dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */