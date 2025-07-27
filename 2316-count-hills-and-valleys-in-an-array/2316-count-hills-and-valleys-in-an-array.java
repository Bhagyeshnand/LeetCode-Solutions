class Solution {
    public int countHillValley(int[] nums) {
        int c = 0;
        for(int i=1;i<nums.length-1;i++) {
            if(nums[i] == nums[i-1]) continue;
            int val = nums[i];
            int left = i-1;
            int right = i+1;
            while(left >= 0 && val == nums[left]) {
                left--;
            }
            while(right < nums.length && val == nums[right]) {
                right++;
            }
            
            if(left >= 0 && right < nums.length) {
                if(val > nums[left] && val > nums[right]) {
                    c++;
                } 
                else if(val < nums[left] && val < nums[right]) {
                    c++;
                }
            }
        }
        return c;
    }
}