class Solution {
    public int countWords(String[] words1, String[] words2) {
        int count = 0;  // Initialize counter for words that appear exactly once in both arrays
        
        // Create sets to track unique words and duplicates from words1
        Set<String> set1 = new HashSet<>(words1.length);  // Unique words from words1
        Set<String> duplicate1 = new HashSet<>(words1.length);  // Duplicates from words1
        
        // Create sets to track unique words and duplicates from words2
        Set<String> set2 = new HashSet<>(words2.length);  // Unique words from words2
        Set<String> duplicate2 = new HashSet<>(words2.length);  // Duplicates from words2
        
        // Process words1: fill set1 with unique words and duplicate1 with repeated words
        for (String word : words1) {
            if (set1.contains(word)) {  // If word already in set1, it's a duplicate
                duplicate1.add(word);  // Add to duplicates set
            } else {
                set1.add(word);  // Otherwise, add to the unique words set
            }
        }
        
        // Process words2: check words that are in set1 and not in duplicate1
        for (String word : words2) {
            if (!set1.contains(word) || duplicate1.contains(word))  // Skip if not in set1 or is duplicate in words1
                continue;
            
            // If word is new in set2, count it; otherwise, track duplicates and adjust count
            if (!set2.contains(word)) {  // If it's the first occurrence in words2
                set2.add(word);  // Add to unique set
                count++;  // Increase count since it appeared exactly once in both sets
            } else if (!duplicate2.contains(word)) {  // If it appears more than once in words2
                duplicate2.add(word);  // Add to duplicate set
                count--;  // Decrease count since it no longer qualifies
            }
        }
        
        return count;  // Return final count of words that appear exactly once in both arrays
    }
}
