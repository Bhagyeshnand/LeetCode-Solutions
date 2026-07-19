class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder();

        int[] count = new int[128];
        boolean[] used = new boolean[128];

        // Count frequency of each character
        for (char c : text.toCharArray()) {
            count[c]++;
        }

        for (char c : text.toCharArray()) {
            count[c]--;

            // Skip if already included
            if (used[c]) {
                continue;
            }

            // Maintain lexicographically smallest order
            while (sb.length() > 0 &&
                   last(sb) > c &&
                   count[last(sb)] > 0) {

                used[last(sb)] = false;
                sb.setLength(sb.length() - 1);
            }

            sb.append(c);
            used[c] = true;
        }

        return sb.toString();
    }

    private char last(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }
}