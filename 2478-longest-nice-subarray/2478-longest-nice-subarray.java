class Solution {
    public int longestNiceSubarray(int[] nums) {

        int bit = 0;
        int max = 1;

         int s = 0;
         int e = 0;
         int n = nums.length;

         while(e < n){


          while( (bit& nums[e]) != 0){

            bit^=nums[s++];

          }


          bit|=nums[e];

          if(e-s+1 > max){
            max = e-s+1;
          }
          e++;



         }

return max;
        
    }
}