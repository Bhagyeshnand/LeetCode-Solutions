class Solution {
    class SegTree {
        int n;
        int[] tree;
        public SegTree(int size) {
            n = 1;
            while (n <= size) n *= 2;
            tree = new int[2 * n];
        }
        
        public void update(int i, int val) {
            for (tree[i += n] = val; i > 1; i >>= 1) {
                tree[i >> 1] = Math.max(tree[i], tree[i ^ 1]);
            }
        }
        
        public int query(int r) {
            int res = 0;
            for (int l = n, r_idx = r + n + 1; l < r_idx; l >>= 1, r_idx >>= 1) {
                if ((l & 1) != 0) 
                    res = Math.max(res, tree[l++]);
                if ((r_idx & 1) != 0) 
                    res = Math.max(res, tree[--r_idx]);
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }
        
        SegTree st = new SegTree(maxX + 1);
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        List<Boolean> res = new ArrayList<>();
        
        for (int[] q : queries) {
            int x = q[1];
            if (q[0] == 1) {
                Integer nxt = obstacles.ceiling(x);
                Integer prev = obstacles.floor(x);
                
                st.update(x, x - prev);
                if (nxt != null) {
                    st.update(nxt, nxt - x);
                }
                obstacles.add(x);
            } else {
                int sz = q[2];
                Integer prev = obstacles.floor(x);
                int mx = Math.max(x - prev, st.query(prev));
                res.add(sz <= mx);
            }
        }
        return res;
    }
}