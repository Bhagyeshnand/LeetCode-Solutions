class Solution {
    static class Event {
        long y;
        int x1, x2;
        int type;

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int[] cnt;
        double[] len;
        double[] xs;

        SegmentTree(double[] xs) {
            this.xs = xs;
            int n = xs.length - 1;
            cnt = new int[4 * n];
            len = new double[4 * n];
        }

        void update(int node, int start, int end, int add_start, int add_end, int val) {
            if (add_start > end || add_end < start) return;

            if (add_start <= start && end <= add_end) {
                cnt[node] += val;
                if (cnt[node] > 0) {
                    len[node] = xs[end + 1] - xs[start];
                } else {
                    len[node] = (start == end) ? 0 : len[node * 2] + len[node * 2 + 1];
                }
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, add_start, add_end, val);
            update(node * 2 + 1, mid + 1, end, add_start, add_end, val);

            if (cnt[node] == 0) {
                len[node] = len[node * 2] + len[node * 2 + 1];
            }
        }

        double query() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {
        Set<Integer> x_set = new TreeSet<>();
        List<Event> events = new ArrayList<>();

        for (int[] sq : squares) {
            int xi = sq[0], yi = sq[1], li = sq[2];
            int xj = xi + li, yj = yi + li;

            x_set.add(xi);
            x_set.add(xj);
            events.add(new Event(yi, xi, xj, 1));
            events.add(new Event(yj, xi, xj, -1));
        }

        List<Integer> x_list = new ArrayList<>(x_set);
        int m = x_list.size();
        double[] xs = new double[m];
        for (int i = 0; i < m; i++) {
            xs[i] = x_list.get(i);
        }

        Map<Integer, Integer> tree_to_list = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tree_to_list.put(x_list.get(i), i);
        }

        events.sort((a, b) -> {
            if (a.y != b.y) return Long.compare(a.y, b.y);
            return Integer.compare(b.type, a.type);
        });

        double total_area = 0;
        double prev_y = events.get(0).y;
        SegmentTree seg1 = new SegmentTree(xs);

        for (Event e : events) {
            double y = e.y;
            double height = y - prev_y;
            double width = seg1.query();
            total_area += width * height;

            int start_idx = tree_to_list.get(e.x1);
            int end_idx = tree_to_list.get(e.x2);
            seg1.update(1, 0, m - 2, start_idx, end_idx - 1, e.type);

            prev_y = y;
        }

        double target = total_area / 2.0;

        prev_y = events.get(0).y;
        double accumulated = 0;
        SegmentTree seg2 = new SegmentTree(xs);

        Event firstEvent = events.get(0);
        seg2.update(1, 0, m - 2,
                   tree_to_list.get(firstEvent.x1),
                   tree_to_list.get(firstEvent.x2) - 1,
                   firstEvent.type);

        for (int i = 1; i < events.size(); i++) {
            Event e = events.get(i);
            double y = e.y;
            double height = y - prev_y;
            double width = seg2.query();

            if (accumulated + width * height >= target) {
                double need = target - accumulated;
                return prev_y + need / width;
            }

            accumulated += width * height;
            prev_y = y;

            int start_idx = tree_to_list.get(e.x1);
            int end_idx = tree_to_list.get(e.x2);
            seg2.update(1, 0, m - 2, start_idx, end_idx - 1, e.type);
        }

        return prev_y;
    }
}