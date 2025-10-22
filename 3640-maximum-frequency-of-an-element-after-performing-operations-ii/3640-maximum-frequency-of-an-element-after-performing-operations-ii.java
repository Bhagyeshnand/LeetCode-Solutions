class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int i = 0;
        // case 1, num is in the arr
        while (i < n) {
            int val = nums[i];
            int same = 0;
            while (i < n && nums[i] == val) {
                same++;
                i++;
            }
            while (right < n && nums[right] <= val + k) {
                right++;
            }
            while (left < n && nums[left] < val - k) {
                left++;
            }
            res = Math.max(res, Math.min(same + ops, right - left));
        }
        // case 2, num is not in the arr
        left = 0;
        right = 0;
        while (right < n) {
            while (right < n && (long) nums[left] + k + k >= nums[right]) {
                right++;
            }
            res = Math.max(res, Math.min(right - left, ops));
            left++;
        }
        return res;
    }
}