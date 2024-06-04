class Solution {
   public int robber(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
         int pick=nums[i];
         if(i>1) pick+=prev2;

         int notpick=prev;
         int curr=Math.max(pick, notpick);
         prev2=prev;
         prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
      int[] ind1=new int[n-1];
      int[] ind2=new int[n-1];
      for(int i=0;i<n-1;i++){
          ind1[i]=nums[i+1];
      }
       for(int i=0;i<n-1;i++){
          ind2[i]=nums[i];
      }
      int a=robber(ind1);
      int b=robber(ind2);
      return Math.max(a, b);
    }
}