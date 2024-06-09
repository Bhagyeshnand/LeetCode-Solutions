class Solution {
    public long countBadPairs(int[] nums) {
         long goodPairs = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}