class Solution {
    public int nthUglyNumber(int n) {
        int t[] = new int[n+1];
        // t[i] = ith ugly number
        // t[n] = return ugly number

        int i2;
        int i3;
        int i5;

       // 1st ugly number
        i2 = i3 = i5 = 1;

        // 1st ugly number
        t[1] = 1;

        for(int i = 2; i<= n; i++){
            int i2UglyNum = t[i2]*2;

            int i3UglyNum = t[i3]*3;

            int i5UglyNum = t[i5]*5;

            int minUglyNum = Math.min(i2UglyNum, Math.min(i3UglyNum,i5UglyNum));

            t[i] = minUglyNum;

            //Jiska Minimum hua uske pointer ko badhate the
            if( minUglyNum == i2UglyNum ) i2++;
            if( minUglyNum == i3UglyNum ) i3++;
            if( minUglyNum == i5UglyNum ) i5++;     
        }
    return t[n];
    }
}