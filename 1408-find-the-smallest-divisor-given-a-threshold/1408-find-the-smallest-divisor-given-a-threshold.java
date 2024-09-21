class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
         Arrays.sort(nums);

        int low = 1, high = nums[nums.length - 1],myAns=1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int energy = 0;
            for (int i = 0; i < nums.length; i++) {

                energy = energy + (int)Math.ceil((double)nums[i] / (double)mid);

            }
            if (energy <= threshold) {
                myAns = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        
        return myAns;
    }
}