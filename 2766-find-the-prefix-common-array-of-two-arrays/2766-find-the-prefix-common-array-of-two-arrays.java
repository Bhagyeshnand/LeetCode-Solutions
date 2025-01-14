class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] seen = new boolean[n + 1];
        int[] result = new int[n];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Check for A[i]
            if (seen[A[i]]) {
                commonCount++;
            } else {
                seen[A[i]] = true;
            }

            // Check for B[i]
            if (seen[B[i]]) {
                commonCount++;
            } else {
                seen[B[i]] = true;
            }

            result[i] = commonCount;
        }

        return result;
    }
}