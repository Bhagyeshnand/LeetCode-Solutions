class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reversed = reversed * 10 + digit;
        }
        return reversed;       
    }
}

// class Solution {
//     public int reverse(int x) {
//         int res =0;
//         boolean isN = x < 0;
//         String s = String.valueOf(Math.abs(x));
//         StringBuilder sb = new StringBuilder(s).reverse();

//         try{
//             res = Integer.parseInt(sb.toString());
//         }catch(NumberFormatException e){
//             return 0;
//         }

//     return isN ? -res : res; 
//     }
// }