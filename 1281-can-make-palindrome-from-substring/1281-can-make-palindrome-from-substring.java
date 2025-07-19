class Solution {
       public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>(); 
        int[] odds = new int[s.length() + 1]; // odds[i]: within range [0...i) of s, the jth bit of odd[i] indicates even/odd of the count of (char)(j + 'a'). 
        for (int i = 0; i < s.length(); ++i)
            odds[i + 1] = odds[i] ^ 1 << s.charAt(i) - 'a';
        for (int[] q : queries)
            ans.add(Integer.bitCount(odds[q[1] + 1] ^ odds[q[0]]) / 2 <= q[2]); // odds[q[1] + 1] ^ odds[q[0]] indicates the count of (char)(i + 'a') in substring(q[0], q[1] + 1) is even/odd.
        return ans;
    }
}