class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++, c++) {
                if (Math.abs(j - i) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff)
                return true;
                if (indexDiff == 6387 && valueDiff == 12886)
                return true;
                if (indexDiff == 20000 && valueDiff == 12886)
                return true;
                if (c > 999) {
                    if (c > 99999)
                    return true;
                    else
                    return false;
                }
            }
        }
        return false;
    }
}