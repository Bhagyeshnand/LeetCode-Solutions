class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int mins = targetSeconds / 60, secs = targetSeconds % 60;  // Convert target seconds into minutes and seconds
        return Math.min(cost(mins, secs, startAt, moveCost, pushCost),  // Calculate cost with mins:secs format
                  cost(mins - 1, secs + 60, startAt, moveCost, pushCost));  // Handle case when seconds are carried over
    }

    private int cost(int mins, int secs, int startAt, int moveCost, int pushCost) {
        if (mins > 99 || secs > 99 || mins < 0 || secs < 0) return Integer.MAX_VALUE;  // Invalid times return max value
        String s = Integer.toString(mins * 100 + secs);  // Convert mins and secs to a string representation
        char curr = (char)(startAt + '0');  // Initialize current finger position as the startAt digit
        int res = 0;  // Initialize total cost
        
        for (int i = 0; i < s.length(); i++) {  // Loop through each digit in the string
            if (s.charAt(i) == curr) {  // If the current digit is under the finger
                res += pushCost;  // Add the push cost
            } else {
                res += pushCost + moveCost;  // If different, add both move and push costs
                curr = s.charAt(i);  // Update finger position to the new digit
            }
        }
        return res;  // Return the total cost
    }
}
