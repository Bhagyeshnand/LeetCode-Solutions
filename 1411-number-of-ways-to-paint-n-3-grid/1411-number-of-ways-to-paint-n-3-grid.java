class Solution {
    int mod = 1_000_000_007;
    public long[][] matrixMultiply(long[][] mat1, long[][] mat2){
        long[][] ans = new long[mat1.length][mat2[0].length];
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat2[0].length;j++){
                for(int k=0;k<mat2.length;k++){
                    ans[i][j] = ((ans[i][j] + mat1[i][k]*mat2[k][j]) % mod);
                }
            }
        }

        return ans;
    }
    public long[][] matrixPower(long[][] mat, int n){
        long[][] ans = {{1, 0},{0, 1}};
        long[][] curr = mat;
        while(n!=0){
            if((n&1) == 1){
                ans = matrixMultiply(ans, curr);
            }
            curr = matrixMultiply(curr, curr);
            n >>= 1;
        }

        return ans;
    }
    public int numOfWays(int n) {
        long[][] mat = {{3,2},{2,2}};
        long[][] multiplyMat = matrixPower(mat, n-1);
        long[][] initialVector = {{6}, {6}};
        long[][] finalVector = matrixMultiply(multiplyMat, initialVector);
        return (int)((finalVector[0][0] + finalVector[1][0]) % mod);
    }
}