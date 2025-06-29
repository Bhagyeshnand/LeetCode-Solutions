class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int n =nums.length;
        int left=0;
        int right = n-1;
        int[] pw = new int[n];
        pw[0] = 1;
        for(int i=1  ; i<n ; i++){
            pw[i] = (pw[i-1]*2)%mod;
        }
        int ans=0;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+pw[right-left])%mod;
                left++;
            }
            else
                right--;

        }
        return ans;
    }
    
}