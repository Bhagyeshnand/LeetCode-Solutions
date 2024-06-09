/* 
Count Good pairs instead of Bad pairs
Ans = Total pairs - No of Good pairs
Number of total pairs where i<j = (n*(n-1))/2

A pair is said to be good if i < j and j - i == nums[j] - nums[i]
This can be rewritten as j - nums[j] == i- nums[i]

Keep a track of this difference using a map

If difference is found in future -
It is a good pair, add its count to goodpair_count
increment its count also in the map as well.
*/


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
