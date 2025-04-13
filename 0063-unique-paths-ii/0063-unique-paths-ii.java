class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        if(arr[0][0] == 0) dp[0][0]=1;
        for(int i=1;i<m;i++){
            if(arr[i][0]==0) dp[i][0] = dp[i-1][0];
        }
        for(int i=1;i<n;i++){
            if(arr[0][i]==0) dp[0][i] = dp[0][i-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][j]==0){
                    if(arr[i-1][j]==0)
                        dp[i][j] += dp[i-1][j]; 
                    if(arr[i][j-1]==0)
                        dp[i][j] += dp[i][j-1];  
                } 
            }
        }
        return dp[m-1][n-1];
    }
}