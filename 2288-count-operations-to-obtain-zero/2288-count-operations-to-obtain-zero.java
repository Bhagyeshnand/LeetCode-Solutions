class Solution {
    public int countOperations(int n1, int n2) {
        int c = 0;
        while (n1 > 0 && n2 > 0) {
            c += n1 / n2;
            n1 %= n2;
            // swap num1 and num2
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        return c;
    }
}