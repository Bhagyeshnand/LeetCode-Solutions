class Solution {
    public long coloredCells(int n) {
        long sum=1; // Initial number of colored cells
        for(int i=2; i<=n; i++){
            sum+=(i-1)*4; // Increment by 4 times the previous level
        }
        return sum;
    }
}