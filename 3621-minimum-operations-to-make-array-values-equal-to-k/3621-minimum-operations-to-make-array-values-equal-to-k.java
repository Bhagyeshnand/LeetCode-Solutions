import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int countK = 0, greater = 0;
        int lastGreater = -1;
        boolean smallerExist = false;

        for (int num : nums) {
            if (num == k) {
                countK++;
            } else if (num > k) {
                if (lastGreater != num) {
                    lastGreater = num;
                    greater++;
                }
            } else {
                smallerExist = true;
            }
        }

        if (countK == nums.length) return 0;
        if (smallerExist) return -1;
        return greater;
    }
}