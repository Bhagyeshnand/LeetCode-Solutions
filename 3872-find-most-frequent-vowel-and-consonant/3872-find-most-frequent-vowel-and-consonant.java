class Solution {
    public int maxFreqSum(String s) {
        // Define the vowel set
        boolean[] vowel = new boolean[26];
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            vowel[c - 'a'] = true;
        }
        
        int[] vow = new int[26];
        int[] cons = new int[26];
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (vowel[idx]) {
                vow[idx]++;
            } else {
                cons[idx]++;
            }
        }
        
        int maxVow = 0;
        int maxCons = 0;
        
        for (int i = 0; i < 26; i++) {
            maxVow = Math.max(maxVow, vow[i]);
            maxCons = Math.max(maxCons, cons[i]);
        }
        
        return maxVow + maxCons;
    }
}
