class Solution {
    public long minimumTotalDistance(List<Integer> r, int[][] f) {
        Collections.sort(r);
        Arrays.sort(f, (x, y) -> x[0] - y[0]);
        int R = r.size();
        int F = f.length;
        long[][] dp = new long[R + 1][F + 1];
        for (int i = 0; i < R; i++) dp[i][F] = Long.MAX_VALUE / 4;
        for (int j = F - 1; j >= 0; j--) {
            long distSum = 0;
            ArrayDeque<long[]> dq = new ArrayDeque<>();
            dq.addLast(new long[]{R, 0});
            for (int i = R - 1; i >= 0; i--) {
                distSum += Math.abs(r.get(i) - f[j][0]);
                while (!dq.isEmpty() && dq.peekFirst()[0] > i + f[j][1])
                    dq.pollFirst();
                long val = dp[i][j + 1] - distSum;
                while (!dq.isEmpty() && dq.peekLast()[1] >= val)
                    dq.pollLast();
                dq.addLast(new long[]{i, val});
                dp[i][j] = dq.peekFirst()[1] + distSum;
            }
        }
        return dp[0][0];
    }
}