class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] map = new int[20001];
        for (int num : nums) {
            map[num + 10000]++;
        }
        int result = 0;
        for (int i = map.length - 1; i > 0; i--) {
            if (map[i] != 0) {
                if (k <= map[i]) {
                    result = i - 10000;
                    break;
                } else {
                    k -= map[i];
                }
            }
        }
        return result;
    }
}