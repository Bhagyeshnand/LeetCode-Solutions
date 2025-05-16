class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length() ) return 0;

        int[][] dp=new int[s.length()+1][t.length()+1];

        for(int si=0; si<=s.length(); si++) dp[si][t.length()]=1;
        
        for(int si=s.length()-1; si>=0; si--){
            for(int ti=t.length()-1; ti>=0; ti--){
                if(s.charAt(si)==t.charAt(ti)){
                    dp[si][ti]= dp[si+1][ti+1] + dp[si+1][ti];
                }
                else dp[si][ti]=dp[si+1][ti];
            }
        }
        return dp[0][0];
    }
}