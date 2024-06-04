class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0;
        double cnt = 0;
        double max = Integer.MIN_VALUE;
        while(r< nums.length){
            cnt += nums[r];
            if(r >= k-1){
            if(cnt/k > max) max = cnt/k;
                cnt -= nums[l];
                l++;
            }
            r++;
        }
        return max;
    }
}