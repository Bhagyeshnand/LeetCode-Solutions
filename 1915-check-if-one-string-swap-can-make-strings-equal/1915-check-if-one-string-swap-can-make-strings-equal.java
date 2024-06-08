class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) return true;

        int firstMismatch = -1;
        int secondMismatch = -1;
        int mismatchCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchCount++;
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    return false;
                }
            }
        }
        
        // Check if there are exactly 2 mismatches and if swapping them makes the strings equal
        return mismatchCount == 2 &&
         s1.charAt(firstMismatch) == s2.charAt(secondMismatch) &&
          s1.charAt(secondMismatch) == s2.charAt(firstMismatch);
    }
}