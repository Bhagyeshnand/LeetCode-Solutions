class Solution {
    private static final int MOD = 105;
    private static final int MOD1 = MOD - 1;
    private static final int[] m = new int[200];
    private static final int[] offline = new int[200];

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        final int[] r = new int[numberOfUsers];
        int all = 0;
        int mlen = 0;
        for (var event : events) {
            final int ts = parseInt(event.get(1));
            final String ids = event.get(2);
            if (event.getFirst().equals("MESSAGE")) {
                if (ids.equals("ALL")) {
                   all++;
                } else if (ids.equals("HERE")) {
                    m[mlen++] = ts * MOD + MOD1;
                } else {
                    for (int i = 0;;) {
                        final int nextSpace = ids.indexOf(' ', i);
                        if (nextSpace < 0) {
                            r[parseInt(ids, i + 2, ids.length())]++;
                            break;
                        }
                        r[parseInt(ids, i + 2, nextSpace)]++;
                        i = nextSpace + 1;
                    }
                }
            } else {
                final int id = parseInt(ids);
                m[mlen++] = ts * MOD + id + 1;
                m[mlen++] = (ts + 60) * MOD;
            }
        }

        int os = 0;
        int oe = 0;
        Arrays.sort(m, 0, mlen);
        for (int i = 0; i < mlen; i++) {
            final var message = m[i] % MOD;
            if (message == 0) {
                os++;
            } else if (message == MOD1) {
                all++;
                for (int j = os; j < oe; j++) {
                    r[offline[j]]--;
                }
            } else {
                offline[oe++] = message - 1;
            }
        }
        if (all > 0) {
            for (int i = 0; i < numberOfUsers; i++) {
                r[i] += all;
            }
        }
        return r;
    }
    private static final int parseInt(String s) {
        return parseInt(s, 0, s.length());
    }

    private static final int parseInt(String ids, int start, int end) {
        int r = ids.charAt(start) - '0';
        for (int i = start + 1; i < end; i++) {
            r = r * 10 + ids.charAt(i) - '0';
        }
        return r;
    }
}