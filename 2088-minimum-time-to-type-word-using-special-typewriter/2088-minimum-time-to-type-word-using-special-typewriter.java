class Solution {
        public int minTimeToType(String word) {
        int cnt = word.length(); // for typing cost
        char prev = 'a';
        for (int i = 0; i < word.length(); ++i) {
            char cur = word.charAt(i);          // current
            int diff = Math.abs(cur - prev);    // prev and curr difference
            cnt += Math.min(diff, 26 - diff);   // go on those side which is min
            prev = cur;                         // updating prev pointer
        }
        return cnt;
    }
}