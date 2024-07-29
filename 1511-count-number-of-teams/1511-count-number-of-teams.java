class Solution {
    public int numTeams(int[] rating) {
    int n = rating.length;
    int total = 0;

        for(int j = 1; j<n-1; j++){
            int rightmax = 0;
            int leftmin = 0;
            int rightmin = 0;
            int leftmax = 0;

            for(int i = 0; i < j; ++i){
                if(rating[i] < rating[j]){
                    leftmin++;
                }else if(rating[i]>rating[j]){
                    leftmax++;
                }
            }

            for(int k = j; k < n; ++k){
                if(rating[j] < rating[k]){
                    rightmax++;
                }else if(rating[j] > rating[k]){
                    rightmin++;
                }
            }

        total += (leftmin * rightmax) + (leftmax * rightmin);

        }
        return total;
    }
}