class Solution {
    public int sumOfUnique(int[] nums) {
       int freq [] = new int [101];
       int sum = 0 ;
       for (int i:nums)
       {
        freq[i]++;
        if (freq[i]==1)
        {
            sum += i;
        }
        else if (freq[i]==2)
         sum-= i;
       }
       return sum ;
       }

    }