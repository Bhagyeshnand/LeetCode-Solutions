class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        final int mask = (1 << 16) - 1;
        int[] tmpNums = new int[nums.length];
        int[] hist = new int[mask + 1];
        for (int shift = 0; shift < 32; shift += 16) {
            Arrays.fill(hist, 0);
            for (var val : nums) {
                hist[(val >>> shift) & mask]++;
            }
            int sum = 0;
            for (int i = 0; i < hist.length; ++i) {
                var tmp = hist[i];
                hist[i] = sum;
                sum += tmp;
            }
            for (var val : nums) {
                tmpNums[hist[(val >>> shift) & mask]++] = val;
            }
            var tmp = tmpNums;
            tmpNums = nums;
            nums = tmp;
        }
        int[][] zero = new int[32][nums.length];
        for (int j = 0; j < 32; ++j) {
            final int prefMask = ~((2 << j) - 1);
            int prevPref = nums[0] & prefMask;
            int prevIdx = 0;
            for (int i = 1; i < nums.length; ++i) {
                if ((nums[i] & (1 << j)) == 0) {
                    prevPref = nums[i] & prefMask;
                    prevIdx = i;
                }
                if ((nums[i] & prefMask) == prevPref && (nums[prevIdx] & (1 << j)) == 0) {
                    zero[j][i] = prevIdx;
                } else {
                    zero[j][i] = i;
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int begin = 0;
            int end = nums.length;
            while (begin < end) {
                int mid = begin + (end - begin) / 2;
                if (nums[mid] <= queries[i][1]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            int idx = begin - 1;
            if (idx < 0) {
                ans[i] = -1;
                continue;
            }
            for (int j = 31; j >= 0; --j) {
                if ((queries[i][0] & (1 << j)) != 0) {
                    idx = zero[j][idx];
                }
            }
            ans[i] = nums[idx] ^ queries[i][0];
        }
        return ans;
    }
}