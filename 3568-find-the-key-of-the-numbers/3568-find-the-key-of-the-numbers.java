class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int sum=0,c=0,co=0;

        while(c<4){
            int a = num1%10, b=num2%10, d=num3%10;
            int e = Math.min(a,Math.min(b,d));
            if(sum==0 && e==0){
                co++;
            }
            sum = (sum*10) + e;
            num1/=10;
            num2/=10;
            num3/=10;
            c++;
        }
        int num=0;
        while(sum!=0){
            int a = sum%10;
            num = (num*10)+a;
            sum/=10;
        }
        while(co!=0){
            num*=10;
            co--;
        }
        return num;
    }
}