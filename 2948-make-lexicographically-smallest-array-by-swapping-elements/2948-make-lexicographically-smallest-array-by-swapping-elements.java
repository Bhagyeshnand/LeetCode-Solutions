
import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = ((long) nums[i] << 32) | (i & 0xffffffffL);
        }

        Arrays.sort(sorted);

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = (int) (sorted[i] >>> 32);
        }

        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                   values[end + 1] - values[end] <= limit) {
                end++;
            }

            int size = end - start + 1;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = (int) sorted[start + i];
            }

            Arrays.sort(indices);

            for (int i = 0; i < size; i++) {
                nums[indices[i]] = values[start + i];
            }

            start = end + 1;
        }

        return nums;
    }
}