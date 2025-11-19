class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean x=true;
        while(x){
            x=found(nums,original);
            original*=2;
        }
        return original/2;
        
    }
    public boolean found(int [] nums,int var){
        for(int ele:nums){
            if(ele==var){
                return true;
            }
        }
        return false;
    }
}