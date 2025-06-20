class Solution {
    public int[] resultArray(int[] nums) {
        int len=nums.length;
        int a1[]=new int[len];
        int a2[]=new int[len];
        int ind1=1,ind2=1;
        a1[0]=nums[0];
        a2[0]=nums[1];
        for(int i=2;i<len;i++)
        {
            if(a1[ind1-1] > a2[ind2-1])
            {
                a1[ind1++]=nums[i];
                
            }
            else
            {
                a2[ind2++]=nums[i];
                //System.out.println(nums[i]);
            }
        }
        for(int i=0;i<ind1;i++)
        {
            if(a1[i]!=0)
            {
                nums[i]=a1[i];
            }
        }
        for(int i=ind1,j=0;j<ind2;j++,i++)
        {
            if(a2[j]!=0)
            {
                nums[i]=a2[j];
            }
        }
        return nums;
    }
}