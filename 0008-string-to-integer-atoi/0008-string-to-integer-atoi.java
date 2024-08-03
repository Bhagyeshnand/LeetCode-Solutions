class Solution {
    public int myAtoi(String s) {
        boolean neg = false;
        int ans=0, i=0;
        int len = s.length();

        while(i<len && s.charAt(i) == ' '){
            i++;
        }

        if(i<len){
            char c = s.charAt(i);
            if(c == '-'){
                neg = true;
                i++;
            }
            else if(c == '+'){
                i++;
            }
        }

        while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9')
        {
            int digit = s.charAt(i) - '0';

            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
    }
}