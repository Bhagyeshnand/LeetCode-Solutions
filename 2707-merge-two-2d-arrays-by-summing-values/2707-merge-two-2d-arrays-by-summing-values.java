class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        
        // Use two pointers to traverse both sorted arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                // If both arrays have the same id, sum the values
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                // If nums1 has a smaller id, add it to result and move pointer i
                result.add(nums1[i]);
                i++;
            } else {
                // If nums2 has a smaller id, add it to result and move pointer j
                result.add(nums2[j]);
                j++;
            }
        }
        
        // Add any remaining elements from nums1
        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }
        
        // Add any remaining elements from nums2
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }
        
        // Convert list to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}