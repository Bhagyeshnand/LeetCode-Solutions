class Solution {
    int[] table;
    int n;
    public int numDecodings(String s) {
        n = s.length();
        table = new int[n];
        Arrays.fill(table, -1);
        return numDecodingsUtil(s, 0);
    }
    private int numDecodingsUtil(String s, int i) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }
        if(table[i] == -1) {
            if(s.charAt(i) == '0') {
                return 0;
            }
            int one = numDecodingsUtil(s, i+1);
            int two = 0;
            if((i+1 < n) && ((s.charAt(i) == '1') || ((s.charAt(i) == '2') && (s.charAt(i+1) < '7')))) {
                two = numDecodingsUtil(s, i+2);
            }
            table[i] = one + two;
        } 
        return table[i];
    }
}