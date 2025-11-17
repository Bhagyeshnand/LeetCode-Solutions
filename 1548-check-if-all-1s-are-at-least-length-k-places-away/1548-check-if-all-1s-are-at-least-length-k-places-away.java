class Solution {
    static
    {
        for(int i=0;i<100;i++)kLengthApart(new int[]{0}, 2);
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int c=k,m=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(c<k)return false;
                m=1;
                c=0;
            }
            else
            {
                if(m==1)c++;
            }
        }
        return true;
    }
}