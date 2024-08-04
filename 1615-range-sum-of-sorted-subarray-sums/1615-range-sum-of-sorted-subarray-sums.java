class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int [] arr = new int[ n*(n+1)/2 ];
        int ind = 0;
        for( int i = 0; i<n; i++){
            int sum = 0;
            for(int j =i ; j<n ; j++){
                sum += nums[j];
                arr[ind++] = sum;
            }  
        }

        Arrays.sort(arr);
        int total = 0;
        final int Mod = (int) 1e9 + 7;
        for(int i = left -1; i<right; i++){
            total = (total + arr[i]) % Mod;
        }
        return total;
    }
}