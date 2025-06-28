class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);

        Arrays.sort(sorted);

        int threshold = sorted[n - k];
        int thresholdCnt = 0;
        for (int i = n - k; i < n; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }

        int[] ans = new int[k];

        int p = 0;
        for (int num : nums) {
            if (num > threshold) {
                ans[p++] = num;
            } else if (num == threshold && thresholdCnt > 0) {
                ans[p++] = num;
                thresholdCnt--;
            }
            if (p== k) {
                break;
            }
        }

        return ans;
    }
}