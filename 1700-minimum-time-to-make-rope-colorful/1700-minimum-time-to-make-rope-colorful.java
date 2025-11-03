class Solution {
    public int minCost(String colors, int[] needed_time) {
        int n_time = 0;
        int n = colors.length();
        int curr_max = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0 || colors.charAt(i) != colors.charAt(i - 1)) {
                curr_max = needed_time[i];
            } else {
                if (needed_time[i] > curr_max) {
                    n_time += curr_max; 
                    curr_max = needed_time[i]; 
                } else {
                    n_time += needed_time[i]; 
                }
            }
        }
        
        return n_time;
    }
}