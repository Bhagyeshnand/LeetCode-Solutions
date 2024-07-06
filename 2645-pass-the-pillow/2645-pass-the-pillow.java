class Solution {
    public int passThePillow(int n, int time) {
         int totalFullRounds = time / (n - 1);
        int timeLeft = time % (n - 1);

        if (totalFullRounds % 2 == 0) {
            return timeLeft + 1;
        } else {
            return n - timeLeft;
        }
    }
}