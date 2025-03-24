class Solution {
    public int countDays(int days, int[][] intervals) {
  Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        int ans = 0;
        for (int i = 0; i < merged.size(); i++) {
            ans += merged.get(i)[1] - merged.get(i)[0] + 1;
        }

        return days - ans;
    }
}