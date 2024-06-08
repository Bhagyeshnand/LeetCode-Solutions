class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
          List<Integer> result = new ArrayList<>();

        // Marking the presence of numbers by making the corresponding index negative
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Finding the indexes that have positive numbers, which indicates the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
    
