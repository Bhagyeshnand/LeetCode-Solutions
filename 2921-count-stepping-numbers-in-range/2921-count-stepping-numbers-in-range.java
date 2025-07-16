class Solution {
    int mod = 1_000_000_007;

    public int countSteppingNumbers(String low, String high) {
        int ans = 0;
        if (low.length() == high.length()) {
            int[][][][] dp = emptyDp(low.length());
            for (int i = low.charAt(0) - '0'; i <= high.charAt(0) - '0'; i++) {
                ans += steppingNums(
                    low,
                    high,
                    low.length(),
                    i,
                    high.charAt(0) - '0' != i,
                    low.charAt(0) - '0' != i,
                    0,
                    dp);
                ans %= mod;
            }
            return ans;
        }

        int[][][][] dp = emptyDp(high.length());
        for (int i = low.charAt(0) - '0'; i < 10; i++) {
            ans += steppingNums(
                low,
                high,
                low.length(),
                i,
                true,
                low.charAt(0) - '0' != i,
                0,
                dp);
            ans %= mod;
        }

        for (int i = high.charAt(0) - '0'; i >= 1; i--) {
            ans += steppingNums(
                low,
                high,
                high.length(),
                i,
                high.charAt(0) - '0' != i,
                true,
                0,
                dp);
            ans %= mod;
        }

        for (int i = low.length() + 1; i < high.length(); i++) {
            dp = emptyDp(i);
            for (int j = 1; j < 10; j++) {
                ans += steppingNums(
                    low,
                    high,
                    i,
                    j,
                    true,
                    true,
                    0,
                    dp);
                ans %= mod;
            }
        }

        return ans;

    }

    int steppingNums(
        String low,
        String high,
        int size,
        int current,
        boolean isAlreadyLower,
        boolean isAlreadyHigher,
        int idx,
        int[][][][] dp
    ) {
        int mem = dp[current][size - idx - 1][toIdx(isAlreadyLower)][toIdx(isAlreadyHigher)];
        if (mem != -1) return mem;
        if (idx == size - 1) return 1;
        int ans = 0;
        if (current > 0 &&
            (isAlreadyLower || (high.charAt(idx + 1) - '0') >= current - 1) &&
            (isAlreadyHigher || (low.charAt(idx + 1) - '0') <= current - 1)

        ) {
            ans += steppingNums(
                low,
                high,
                size,
                current - 1,
                isAlreadyLower || (high.charAt(idx + 1) - '0') > current - 1,
                isAlreadyHigher || (low.charAt(idx + 1) - '0') < current - 1,
                idx + 1,
                dp
            );
            ans %= mod;
        }

        if (current < 9 &&
            (isAlreadyLower || (high.charAt(idx + 1) - '0') >= current + 1) &&
            (isAlreadyHigher || (low.charAt(idx + 1) - '0') <= current + 1)

        ) {
            ans += steppingNums(
                low,
                high,
                size,
                current + 1,
                isAlreadyLower || (high.charAt(idx + 1) - '0') > current + 1,
                isAlreadyHigher || (low.charAt(idx + 1) - '0') < current + 1,
                idx + 1,
                dp
            );
            ans %= mod;
        }

        dp[current][size - idx - 1][toIdx(isAlreadyLower)][toIdx(isAlreadyHigher)] = ans;
        return ans;
    }


    int toIdx(boolean bool) {
        return bool ? 0 : 1;
    }


    int[][][][] emptyDp(int size) {
        int[][][][] dp = new int[10][size][2][2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return dp;
    }
}