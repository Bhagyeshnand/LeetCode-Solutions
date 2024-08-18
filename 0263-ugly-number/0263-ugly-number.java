class Solution {
    public boolean isUgly(int n) {
        // If the number is 0, it's not considered an ugly number
        if(n == 0){
            return false;
        }

        // If the number is between 1 and 3, it's inherently an ugly number
        if(n <= 3 && n > 0){
            return true;
        }

        // If divisible by 2, recursively check the result of dividing by 2
        if(n % 2 == 0){
            return isUgly(n / 2);
        }

        // If divisible by 3, recursively check the result of dividing by 3
        if(n % 3 == 0){
            return isUgly(n / 3);
        }

        // If divisible by 5, recursively check the result of dividing by 5
        if(n % 5 == 0){
            return isUgly(n / 5);
        }

        // If not divisible by 2, 3, or 5, it's not an ugly number
        return false;
    }   
}