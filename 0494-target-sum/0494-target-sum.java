class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, mid = n / 2;
        List<Long> sums1 = new ArrayList<>(), sums2 = new ArrayList<>();
        computeSums(nums, 0, mid, sums1);
        computeSums(nums, mid, n, sums2);
        Map<Long, Long> countMap = new HashMap<>();
        for (long sum : sums2) countMap.put(sum, countMap.getOrDefault(sum, 0L) + 1);
        long total = 0;
        for (long sum : sums1) {
            long complement = (long) target - sum;
            total += countMap.getOrDefault(complement, 0L);
        }
        return (int) total;
    }

    private void computeSums(int[] nums, int start, int end, List<Long> sums) {
        sums.add(0L);
        for (int i = start; i < end; ++i) {
            int num = nums[i], n = sums.size();
            for (int j = 0; j < n; ++j) {
                sums.add(sums.get(j) + num);
                sums.set(j, sums.get(j) - num);
            }
        }
    }
}