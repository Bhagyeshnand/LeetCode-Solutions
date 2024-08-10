class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        
        long result = 0;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                if(nums[i] > nums[j]) {
                    for(int k=j+1; k<n; k++) {
                        result = Math.max(result, ((long)nums[i] - (long)nums[j]) * nums[k]);
                    }
                }
            }
        }
        
        return result;
    }
}
