class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        return new Solver(allowed, bottom.length()).canDo(bottom);
    }

    static final class Solver {
        final int[][] cache;
        final int[][][] allowed = new int[6][6][];

        public Solver(List<String> allowed, int len) {
            final int[][] cnt = new int[6][6];
            for (String a : allowed) {
                cnt[a.charAt(0) - 'A'][a.charAt(1) - 'A']++;
            }
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    this.allowed[i][j] = new int[cnt[i][j]];
                }
            }
            this.cache = new int[len][];
            int size = 6 * 6;
            for (int i = 3; i < len; i++) {
                cache[i] = new int[size *= 6];
            }
            for (String a : allowed) {
                final int first = a.charAt(0) - 'A';
                final int second = a.charAt(1) - 'A';
                final int third = a.charAt(2) - 'A';
                this.allowed[first][second][--cnt[first][second]] = third;
            }
        }

        boolean canDo(String s) {
            final int[] arr = new int[s.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.charAt(i) - 'A';
            }
            return s.length() == 2 ? allowed[arr[0]][arr[1]].length > 0 : compute(arr, arr.length);
        }

        boolean canDo(int[] arr, int len) {
            if (len == 2) {
                return allowed[arr[0]][arr[1]].length > 0;
            } else {
                final var key = encode(arr, len);
                final var cached = cache[len][key];
                if (cached != 0) {
                    return cached == 1;
                }
                final var result = compute(arr, len);
                cache[len][key] = result ? 1 : 2;
                return result;
            }
        }
        
        private int encode(int[] arr, int len) {
            int r = arr[0];
            for (int i = 1; i < len; i++) {
                r = r * 6 + arr[i];
            }
            return r;
        }

        boolean compute(int[] arr, int len) {
            for (int i = 2; i < len; i++) {
                if (allowed[arr[i - 1]][arr[i]].length == 0) {
                    return false;
                }
            }
            return compute(new int[len], 0, arr, 0, len);
        }

        boolean compute(int[] prefix, int plen, int[] suffix, int sidx, int slen) {
            if (plen > 1 && !canDo(prefix, plen)) {
                return false;
            }
            final int nextSidx = sidx + 1;
            if (nextSidx < slen) {
                for (int next : allowed[suffix[sidx]][suffix[nextSidx]]) {
                    prefix[plen] = next;
                    if (compute(prefix, plen + 1, suffix, sidx + 1, slen)) {
                        return true;
                    }
                }
            } else {
                return canDo(prefix, plen);
            }
            return false;
        }
    }
}