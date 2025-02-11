    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] re = new int[nums.length + 1 - k];

        int maxId = 0;
        int max = Integer.MIN_VALUE;

        for (int x = 0; x < k; x++) {
            if (nums[x] >= max) {
                max = nums[x];
                maxId = x;
            }
        }

        re[0] = max;
        
        for(int i=1, end; i<re.length; i++){
            end = i+k-1;

            if(i <= maxId){
                if(max <= nums[end]){
                    max = nums[end];
                    maxId = end;
                }
            }
            else{
                if(nums[end] >= max-1){
                    max = nums[end];
                    maxId = end;
                } 
                else if(nums[i] == max-1 || nums[i] == max){
                    max = nums[i];
                    maxId = i;
                } 
                else{
                    max = Integer.MIN_VALUE;
                    for(int x=i ; x<end+1 ; x++){
                        if(nums[x] >= max){
                            max = nums[x];
                            maxId = x;
                        }
                    }
                }
            }
            re[i] = max;
        }

        return re;
    }
}