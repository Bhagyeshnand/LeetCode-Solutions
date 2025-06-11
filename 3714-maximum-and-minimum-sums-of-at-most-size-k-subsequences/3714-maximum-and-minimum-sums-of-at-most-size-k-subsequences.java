class Solution {
    private static final int MOD = 1000000007;

    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        long[] inv = new long[n + 2];
        Arrays.fill(inv, 1);

        for (int i = 2; i <= n; i++) {
            inv[i] = MOD - (MOD / i) * inv[(int) (MOD % i)] % MOD;
        }

        int kPrime = k - 1;
        long[] Ck = new long[n + 1];
        if (kPrime >= 1) {
            Ck[kPrime] = 1;
            for (int m = kPrime + 1; m <= n; m++) {
                Ck[m] = (Ck[m - 1] * m) % MOD;
                Ck[m] = (Ck[m] * inv[m - kPrime]) % MOD;
            }
        }

        long[] sumC = new long[n + 1];
        if (kPrime < 1) {
            Arrays.fill(sumC, 1);
        } else {
            sumC[0] = 1;
            for (int m = 1; m <= n; m++) {
                sumC[m] = (2 * sumC[m - 1]) % MOD;
                if (m - 1 >= kPrime) {
                    sumC[m] = (sumC[m] - Ck[m - 1] + MOD) % MOD;
                }
            }
        }

        int[] sortedAsc = nums.clone();
        Arrays.sort(sortedAsc);
        int[] sortedDesc = sortedAsc.clone();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = sortedDesc[i];
            sortedDesc[i] = sortedDesc[j];
            sortedDesc[j] = temp;
        }

        long sumMin = 0;
        for (int i = 0; i < n; i++) {
            int m = n - i - 1;
            if (m < 0) continue;
            long contrib = sortedAsc[i];
            if (m >= 0) {
                contrib = contrib * sumC[m] % MOD;
            }
            sumMin = (sumMin + contrib) % MOD;
        }

        long sumMax = 0;
        for (int i = 0; i < n; i++) {
            int m = n - i - 1;
            if (m < 0) continue;
            long contrib = sortedDesc[i];
            if (m >= 0) {
                contrib = contrib * sumC[m] % MOD;
            }
            sumMax = (sumMax + contrib) % MOD;
        }

        long total = (sumMin + sumMax) % MOD;
        return (int) total;
    }
}