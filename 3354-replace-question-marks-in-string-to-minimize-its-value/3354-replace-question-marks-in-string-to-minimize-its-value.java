class Solution {
    public String minimizeStringValue(String s) {
        final char[] arr = s.toCharArray();
        final int[] cnt = new int[26];
        for (char c : arr) {
            if (c != '?') {
                cnt[c - 'a']++;
            }
        }
        perchar(cnt, arr.length);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                while (cnt[idx] == 0) {
                    idx++;
                }
                arr[i] = (char) ('a' + idx);
                cnt[idx]--;
            }
        }
        return new String(arr);
    }

    static void perchar(int[] cnt, int len) {
        int min = 0, max = len;
        while (min < max) {
            final int middle = (min + max) / 2;
            if (count(cnt, middle) < len) {
                min = middle + 1;
            } else {
                max = middle;
            }
        }
        int over = count(cnt, min) - len;
        for (int i = 25; i >= 0; i--) {
            final int avail = min - cnt[i];
            cnt[i] = avail > 0 ? over-- > 0 ? avail - 1 : avail : 0;
        }
    }

    static int count(int[] cnt, int perchar) {
        int r = 0;
        for (int c : cnt) {
            r += Math.max(c, perchar);
        }
        return r;
    }
}