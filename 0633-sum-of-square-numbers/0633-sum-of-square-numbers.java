class Solution {
    public boolean judgeSquareSum(int c) {
        long s = 0, e = (long) Math.sqrt(c), sum;
        while(s <= e){
            sum = (s*s) + (e*e);
            if(sum < c) s++;
            else if(sum > c) e--;
            else return true;
        }
        return c == 1;
    }
}