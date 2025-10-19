// https://www.youtube.com/@0x3f
class Solution {
    public String findLexSmallestString(String S, int a, int b) {
        char[] s = S.toCharArray();
        int n = s.length;
        char[] t = new char[n];
        int step = gcd(b, n);
        int g = gcd(a, 10);
        String ans = null;

        for (int i = 0; i < n; i += step) {
            // t = s[i,n) + s[0,i)
            System.arraycopy(s, i, t, 0, n - i);
            System.arraycopy(s, 0, t, n - i, i);

            modify(t, 1, g); // 累加操作（所有奇数下标）
            if (step % 2 > 0) { // 能对偶数下标执行累加操作
                modify(t, 0, g); // 累加操作（所有偶数下标）
            }

            String str = new String(t);
            if (ans == null || str.compareTo(ans) < 0) {
                ans = str;
            }
        }

        return ans;
    }

    private void modify(char[] t, int start, int g) {
        int ch = t[start] - '0'; // 最靠前的数字，越小越好
        // ch 可以变成的最小值为 ch%g
        // 例如 ch=5，g=2，那么 ch+2+2+2（模 10）后变成 1，不可能变得更小
        // 从 ch 到 ch%g，需要增加 inc，其中 +10 保证 inc 非负（循环中会 %10 保证结果在 [0,9] 中）
        int inc = ch % g - ch + 10;
        for (int j = start; j < t.length; j += 2) {
            t[j] = (char) ('0' + (t[j] - '0' + inc) % 10);
        }
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}