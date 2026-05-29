class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int num : nums) {

            int sum = 0;

            while(num > 0) {

                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }

            min = Math.min(sum, min);
        }

        return min;
    }
}