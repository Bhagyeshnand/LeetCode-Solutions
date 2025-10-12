// https://www.youtube.com/@0x3f
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 31;

    private static final long[] F = new long[MX]; // F[i] = i!
    private static final long[] INV_F = new long[MX]; // INV_F[i] = i!^-1

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }

        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_F[i - 1] = INV_F[i] * i % MOD;
        }
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] powV = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            powV[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                powV[i][j] = (int) ((long) powV[i][j - 1] * nums[i] % MOD);
            }
        }

        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
        return (int) (dfs(0, m, 0, k, powV, memo) * F[m] % MOD);
    }

    private long dfs(int i, int leftM, int x, int leftK, int[][] powV, int[][][][] memo) {
        int c1 = Integer.bitCount(x);
        if (c1 + leftM < leftK) { // 可行性剪枝
            return 0;
        }
        if (i == powV.length) {
            return leftM == 0 && c1 == leftK ? 1 : 0;
        }
        if (memo[i][leftM][x][leftK] != -1) {
            return memo[i][leftM][x][leftK];
        }
        long res = 0;
        for (int j = 0; j <= leftM; j++) { // 枚举 I 中有 j 个下标 i
            // 这 j 个下标 i 对 S 的贡献是 j * pow(2, i)
            // 由于 x = S >> i，转化成对 x 的贡献是 j
            int bit = (x + j) & 1; // 取最低位，提前从 leftK 中减去，其余进位到 x 中
            if (bit <= leftK) {
                long r = dfs(i + 1, leftM - j, (x + j) >> 1, leftK - bit, powV, memo);
                res = (res + r * powV[i][j] % MOD * INV_F[j]) % MOD;
            }
        }
        return memo[i][leftM][x][leftK] = (int) res;
    }
}