class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] CumXor = new int[n];

        CumXor[0] = arr[0];
        for(int i=1; i<n; i++){
            CumXor[i] = CumXor[i-1] ^ arr[i];
        } 

        int[] ans = new int[queries.length];
        int i=0;
        for(int[] q : queries){
            int L = q[0];
            int R = q[1];
            
            ans[i++] = CumXor[R] ^ (L == 0 ? 0 : CumXor[L-1]);

        }
    return ans;
    }
}