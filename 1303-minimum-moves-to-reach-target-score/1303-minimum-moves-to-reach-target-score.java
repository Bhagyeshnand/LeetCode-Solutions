class Solution {
    public int minMoves(int target, int maxDoubles) {
        return sol(target , maxDoubles , 0);
    }

    int sol(int target , int maxDoubles ,int ans){
        if(target==1)return ans;
        if(maxDoubles==0)return ans + target-1;
        if(target%2==0 && maxDoubles > 0){
            return sol(target/2 , --maxDoubles , ++ans);
        }else return sol(--target , maxDoubles , ++ans);
    }
}