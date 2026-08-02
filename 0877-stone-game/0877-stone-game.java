class Solution {
    public boolean stoneGame(int[] piles) {
       Integer[][]arr=new Integer[piles.length][piles.length];
        return helper(piles,0,piles.length-1,arr)>=0;
    }
    public static int helper(int[]arr,int start,int end,Integer[][]dp){
        if(start==end)return arr[start];
        if(dp[start][end]!=null)return dp[start][end];
        int takeStart=arr[start]-helper(arr,start+1,end,dp);
        int takeEnd=arr[end]-helper(arr,start,end-1,dp);
        return dp[start][end]=Math.max(takeStart,takeEnd);
    }
}