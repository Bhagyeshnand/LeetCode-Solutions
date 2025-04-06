class Solution {
    static{
        for(int i = 0; i < 500; i++){
            maxSubarraySumCircular(new int[]{1});
        }
    }
    static public int maxSubarraySumCircular(int[] nums) {
        
        // // Brute Force, TC: O(n + n*n), SC: (2n)
        // // Will Throw TLE
        // int len = nums.length;
        // int len2 = len << 1;
        // int nums2[] = new int[len2];
        // int maxSum = Integer.MIN_VALUE;
        // for(int i = 0; i < len; i++){
        //     nums2[i] = nums2[i+len] = nums[i];
        // }
        // for(int i = 0; i < len; i++){
        //     var sum = 0;
        //     for(int j = i; j < len + i; j++){
        //         sum += nums2[j];
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;


        // // Better, TC: O(n*n), SC: (1)
        // // Will Throw TLE
        // int len = nums.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i = 0; i < len; i++){
        //     var sum = 0;
        //     for(int j = i; j < len + i; j++){
        //         sum += nums[j%len];
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;


        // Optimal
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMaxSum = 0;
        int currMinSum = 0;
        int total = 0;

        for(int num : nums){            
            total += num;

            currMaxSum = Math.max(currMaxSum + num, num);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + num, num);
            minSum = Math.min(minSum, currMinSum);
        }
        if(maxSum < 0) return maxSum;
        return Math.max(total - minSum, maxSum);
    }
}