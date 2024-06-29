class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int mx = 0;
        for(int n : nums){
            mx = Math.max(mx,n);

        }
        int [] freqs = new int[mx+1];
        for(int n : nums){
            ++freqs[n];
        }
        int[][] subs = new int[nums.length/3][3];
        for(int n = 1, r=0, c=0; r<subs.length && n <= mx;){
            if(freqs[n] == 0){
                n++;

            }
            else if(c==subs[r].length){
                r++;
                c=0;
            }
            else if(c==0 || n-subs[r][0] <= k){
                subs[r][c] = n;
                --freqs[n];
                c++;
                
            }
            else return new int[0][0];
        }
        return subs;

          }
}