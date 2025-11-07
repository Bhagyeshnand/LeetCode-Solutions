class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;

        // 1) compute initial power for each city using sliding window
        long[] power = new long[n];
        long window = 0;
        int windowSize = 2 * r + 1;
        // initial window from 0 to min(n-1, r)
        for (int j = 0; j <= Math.min(n - 1, r); j++) window += stations[j];
        for (int i = 0; i < n; i++) {
            // window currently covers [i-r, i+r] clipped to [0, n-1]
            power[i] = window;
            // slide window: remove left element (i-r) and add right element (i+r+1)
            int removeIdx = i - r;
            if (removeIdx >= 0) window -= stations[removeIdx];
            int addIdx = i + r + 1;
            if (addIdx < n) window += stations[addIdx];
        }

        // 2) binary search answer
        long low = 0;
        long high = Arrays.stream(power).max().orElse(0L) + k; // upper bound
        long best = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReach(power, r, k, mid)) {
                best = mid;
                low = mid + 1; // try larger minimum power
            } else {
                high = mid - 1;
            }
        }
        return best;
    }

    // Check if we can make every city's power >= target using <= k extra stations
    private boolean canReach(long[] power, int r, long k, long target) {
        int n = power.length;
        long used = 0L;
        long[] diff = new long[n + 1]; // difference array for added stations' effect
        long curAdd = 0L;

        for (int i = 0; i < n; i++) {
            curAdd += diff[i];                 // apply scheduled removals/adds
            long total = power[i] + curAdd;    // current power at city i
            if (total < target) {
                long need = target - total;    // number of new stations to place
                used += need;
                if (used > k) return false;
                curAdd += need; // stations we add now affect current city immediately

                // these need stations placed at pos = i + r (rightmost covering i)
                // they will stop affecting after index i + 2*r
                int end = Math.min(n, i + 2 * r + 1);
                diff[end] -= need; // schedule removal at end
            }
        }
        return true;
    }
}