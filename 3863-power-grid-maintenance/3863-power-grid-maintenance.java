class Solution {
    static class DSU {
        int[] parent;
        int[] size;
        int comps;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            comps = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] == u)
                return u;
            int curParent = parent[u];
            return parent[u] = find(curParent);
        }

        public boolean union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv)
                return false;

            if (size[pu] > size[pv]) {
                size[pu] += size[pv];
                parent[pv] = parent[pu];
            } else {
                size[pv] += size[pu];
                parent[pu] = parent[pv];
            }
            comps--;
            return true;
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        int[] offlineCount = new int[c + 1];
        int[] min = new int[c + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        int n = 0;
        for (int[] con : connections) {
            dsu.union(con[0], con[1]);
        }

        for (int[] query : queries) {
            if (query[0] == 2) {
                offlineCount[query[1]]++;
            } else
                n++;
        }

        for (int node = 1; node <= c; node++) {
            if (offlineCount[node] == 0) {
                int root = dsu.find(node);
                min[root] = Math.min(min[root], node);
            }

        }

        int[] res = new int[n];

        for (int i = queries.length - 1; i >= 0; i--) {
            int first = queries[i][0];
            int station = queries[i][1];
            int root = dsu.find(station);
            if (first == 1) {
                boolean isOnline = (offlineCount[station] == 0);
                if (isOnline) {
                    res[--n] = station;
                } else {
                    int minStation = min[root];
                    res[--n] = minStation == Integer.MAX_VALUE ? -1 : minStation;
                }
            } else {
                offlineCount[station]--;
                if (offlineCount[station] == 0) {
                    min[root] = Math.min(station, min[root]);
                }

            }
        }
        return res;
    }
}