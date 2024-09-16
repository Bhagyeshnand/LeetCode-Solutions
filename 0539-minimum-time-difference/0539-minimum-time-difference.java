class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;  // More than 1440 points means duplicates must exist

        boolean[] seen = new boolean[1440];  // Boolean array to track seen minutes
        
        for (String time : timePoints) {
            int minutes = convertToMinutes(time);  // Convert time to total minutes from 00:00
            if (seen[minutes]) return 0;  // If the minute is already seen, return 0 as the difference is zero
            seen[minutes] = true;  // Mark this minute as seen in the array
        }
        
        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;  // Initialize first and previous seen times
        int minDiff = Integer.MAX_VALUE;  // Initialize minimum difference as maximum value
        
        for (int i = 0; i < 1440; i++) {  // Loop through all minutes in a day
            if (seen[i]) {  // If this minute has been recorded
                if (first == Integer.MAX_VALUE) {  
                    first = i;  // Set the first time when encountered
                } else {
                    minDiff = Math.min(minDiff, i - prev);  // Calculate difference between current and previous time
                }
                prev = i;  // Update previous to the current minute
            }
        }
        
        minDiff = Math.min(minDiff, 1440 - prev + first);  // Handle the circular difference (last to first across midnight)
        
        return minDiff;  // Return the smallest time difference found
    }
    
    private int convertToMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60  // Convert hour part to minutes
             + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');  // Add minute part
    }
}
