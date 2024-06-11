class Solution {
    public List<Integer> findLonely(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for( int n : nums) if(n > max) max = n;

        int freq[] = new int[max+3];

        for(int n : nums) ++freq[n+1];

        for(int n : nums){
            if(freq[n+1] == 1 && freq[n] == 0 && freq[n+2] == 0){
                ans.add(n);
            }
        }
        return ans;
    }
}
