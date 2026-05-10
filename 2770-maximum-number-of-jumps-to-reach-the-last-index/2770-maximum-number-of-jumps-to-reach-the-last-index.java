class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] maxJumps = new int[n];
        maxJumps[0] = 0;

        for(int j = 1 ; j < n ; j++) {
            int maximum = -1;
            for(int i = 0 ; i < j ; i++) {  
                if((long) nums[j] >= (long) nums[i] - (long) target && (long) nums[j] <= (long) nums[i] + (long) target && (maxJumps[i] != -1)) 
                    maximum = Math.max(maximum, maxJumps[i] + 1);
            }
            maxJumps[j] = maximum;
        }

        System.out.println(Arrays.toString(maxJumps));

        return maxJumps[n-1];
    }
}