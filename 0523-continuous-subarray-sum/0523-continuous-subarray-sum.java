class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>(nums.length+1);
        hm.put(0,-1);
        int sum = 0;

        for( int i = 0; i<nums.length;i++){
            sum += nums[i];
            int remainder = sum % k;
            if(hm.containsKey (remainder) ){
                if(i - hm.get(remainder) >= 2)
                    return true;
                }else{
                    hm.put(remainder, i);
                }
        }
        return false;
    }
}