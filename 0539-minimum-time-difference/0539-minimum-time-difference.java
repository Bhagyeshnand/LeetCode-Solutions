class Solution {
    public int findMinDifference(List<String> tp) {
        int n = tp.size(), i = 0;
        int[] minute = new int[n];

        for(String s : tp){
            String[] part = s.split(":");

            int hour    = Integer.parseInt(part[0]);
            int minutes = Integer.parseInt(part[1]);

            minute[i++] = hour * 60 + minutes;
        }

        Arrays.sort(minute);

        int result = 1440, diff = 0;
        for(i = 1 ; i< n; i++){
            diff = minute[i] - minute[i-1]; 
            result = Math.min(result, diff);
        }

        result = Math.min(result, (24 * 60 - minute[n-1]) + minute[0]);
        return result;
    }
   
}