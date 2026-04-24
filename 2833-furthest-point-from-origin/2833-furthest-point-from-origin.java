class Solution {
    private static final char LETTER_L = 'L';
    private static final char LETTER_R = 'R';
    private static final char CHARACTER_ = '_';

    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();

        int countL = 0;
        int countR = 0;
        int countUnderscore = 0;
        
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c == LETTER_L) {
                countL++;
            } else if (c == LETTER_R) {
                countR++;
            } else if (c == CHARACTER_) {
                countUnderscore++;
            }
        }

        int positionAllL = (countL + countUnderscore) - countR;
        int positionAllR = countL - (countR + countUnderscore);
        
        return Math.max(Math.abs(positionAllL), Math.abs(positionAllR));
    }
}