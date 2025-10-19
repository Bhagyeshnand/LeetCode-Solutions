class Solution {
    public String findLexSmallestString(String S, int a, int b) {
        char[] s = S.toCharArray();
        int n = s.length;
        int step = gcd(b, n);
        int g = gcd(a, 10);
        String ans = S;

        for (int i = 0; i < n; i += step) {
            char[] t = rotate(s, i, n);
            
            optimizeDigits(t, 1, g);
            
            if (step % 2 == 1) {
                optimizeDigits(t, 0, g);
            }

            String candidate = new String(t);
            if (candidate.compareTo(ans) < 0) {
                ans = candidate;
            }
        }

        return ans;
    }

    private char[] rotate(char[] s, int start, int n) {
        char[] rotated = new char[n];
        System.arraycopy(s, start, rotated, 0, n - start);
        System.arraycopy(s, 0, rotated, n - start, start);
        return rotated;
    }

    private void optimizeDigits(char[] t, int start, int g) {
        int firstDigit = t[start] - '0';
        int minValue = firstDigit % g;
        int inc = (minValue - firstDigit + 10) % 10;
        
        for (int j = start; j < t.length; j += 2) {
            t[j] = (char) ('0' + (t[j] - '0' + inc) % 10);
        }
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}