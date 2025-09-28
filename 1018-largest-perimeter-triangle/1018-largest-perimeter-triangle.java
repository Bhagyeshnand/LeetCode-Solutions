class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        //Just find two largest elements. No need to sort the whole array
        selectAndSwapMax(nums, n - 1);
        selectAndSwapMax(nums, n - 2);

        // Iterate backward from the end to the third element
        for (int i = n - 1; i >= 2; i--) {

            //Find third element inside the loop because of the inequality condition :
            // Place the third max element in nums[0..i-2] at position i-2
            selectAndSwapMax(nums, i - 2);

            // Check the triangle inequality on the triplet
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        // No valid triangle found
        return 0;
    }

    // Selects the maximum element from nums[0..idx] and swaps it with nums[idx]
    private void selectAndSwapMax(int[] nums, int idx) {
        int maxValue = nums[0];
        int maxIndex = 0;

        // Find the max element and its index in nums[0..idx]
        for (int i = 1; i <= idx; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        // Swap max element to the position idx
        int temp = nums[idx];
        nums[idx] = maxValue;
        nums[maxIndex] = temp;
    }
}