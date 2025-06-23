class Solution {
    public long kMirror(int k, int n) {
        int[] remain = new int[]{n};
        long r = 0;
        int i = 1;
        while (remain[0] > 0) {
            r += calculate(k, remain, i);
            i++;
        }
        return r;
    }

    private long calculate(int k, int[] remain, int d) {
        long[] sum = new long[]{0};
        search(new int[d], k, 0, true, remain, sum);
        if (remain[0] > 0) {
            search(new int[d], k, 0, false, remain, sum);
        }
        return sum[0];
    }

    private void search(int[] num, int k, int i, boolean odd, int[] remain, long[] sum) {
        if (i >= num.length) {
            int base = 1;
            long v = 0;
            for (int j = 0; j < num.length; j++) {
                v = v * k + num[j];
            }
            for (int j = num.length-1; j >= 0; j--) {
                if (odd && j == num.length-1) {
                    continue;
                }
                v = v * k + num[j];
            }
            if (mirror(v)) {
                // System.out.println(v);
                remain[0]--;
                sum[0] += v;
            }
            return;
        }
        for (int j = 0; j < k; j++) {
            if (i == 0 && j == 0) {
                continue;
            }
            num[i] = j;
            search(num, k, i+1, odd, remain, sum);
            if (remain[0] <= 0) {
                break;
            }
        }
    }

    private boolean mirror(long v) {
        String s = String.valueOf(v);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}