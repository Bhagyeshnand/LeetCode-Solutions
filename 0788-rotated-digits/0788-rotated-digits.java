
class Solution {
    public int rotatedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Integer[][][] memo = new Integer[digits.length][2][2];
        return dfs(0, 1, 0, digits, memo);
    }

    private int dfs(int pos, int tight, int changed, char[] digits, Integer[][][] memo) {
        if (pos == digits.length) {
            return changed == 1 ? 1 : 0;
        }

        if (memo[pos][tight][changed] != null) {
            return memo[pos][tight][changed];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;
        int count = 0;

        for (int d = 0; d <= limit; d++) {
            if (d == 3 || d == 4 || d == 7) {
                continue;
            }

            int nextTight = tight == 1 && d == limit ? 1 : 0;
            int nextChanged = changed;

            if (d == 2 || d == 5 || d == 6 || d == 9) {
                nextChanged = 1;
            }

            count += dfs(pos + 1, nextTight, nextChanged, digits, memo);
        }

        memo[pos][tight][changed] = count;
        return count;
    }
}