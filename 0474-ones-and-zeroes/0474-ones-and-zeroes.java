class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=l;i++){
            int one=0,zero=0;
            String x=strs[i-1];
            for(char c:x.toCharArray())if(c=='0')zero++;
            one=x.length()-zero;
            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                    if(dp[j-zero][k-one]>0){
                        dp[j][k]=Math.max(dp[j][k],1 + dp[j-zero][k-one]);
                    }
                }
            }
        }
        int ans=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans-1;
    }
}

// class Solution {
//     public int findMaxForm(String[] strs, int m, int n) {
        
//         int len = strs.length;

//         int[][] map = new int[len][2];
//         for(int i=0; i<len; i++) {
//             int l = strs[i].length();
//             for(int j=0; j<l; j++) {
//                 char ch = strs[i].charAt(j);
//                 if(ch == '1') {
//                     map[i][1]++;
//                 }
//                 else {
//                     map[i][0]++;
//                 }
//             }
//         }

//         Integer[][][] dp = new Integer[len+1][m+1][n+1];
//         return recur(map, 0, m, n, dp);
//     }

//     public int recur(int[][] map, int index, int m, int n, Integer[][][] dp) {

//         if(m == 0 && n == 0) return dp[index][m][n] = 0;
//         if(m < 0 || n < 0) return Integer.MIN_VALUE;
//         if(index >= map.length) return dp[index][m][n] = 0;

//         if(dp[index][m][n] != null) return dp[index][m][n];

//         int pick = Integer.MIN_VALUE;
//         if(m >= map[index][0] && n >= map[index][1]) {
//             pick = 1 + recur(map, index + 1, m-map[index][0], n-map[index][1], dp);   
//         }

//         int noPick = recur(map, index + 1, m, n, dp);

//         return dp[index][m][n] = Math.max(pick, noPick);
//     }
// }