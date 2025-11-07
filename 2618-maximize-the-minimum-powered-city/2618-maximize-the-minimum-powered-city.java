class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + stations[i];
        }
        long[] power = new long[n];
        for (int i = 0; i < n; ++i) {
            power[i] = preSum[Math.min(i + r, n - 1) + 1] - preSum[Math.max(i - r, 0)];
        }
        long left = 0, right = 10000000000L + 1000000000L;
        while (left <= right) {
            long mid = left + (right - left)/2;
            if (check(power, r, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(long[] power, int r, int k, long min) {
        long[] diff = new long[power.length + 1];
        long s = 0;
        for (int i = 0; i < power.length; ++i) {
            s += diff[i];
            if (power[i] + s < min) {
                long incr = min - (power[i] + s);
                if (incr > k) {
                    return false;
                }
                diff[Math.min(i + 2*r, power.length - 1) + 1] -= incr;
                s += incr;
                k -= incr;
            }
        }
        return true;
    }
}