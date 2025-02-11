class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ls = s.length(), lp = p.length();
        List<Integer> res = new ArrayList<>();
        
        // If p is longer than s, there is no possible solution
        if (lp > ls) return res;
        
        // Creating an array to store the frequency of all letters (26 for lowercase a-z)
        int[] freq = new int[26];
        
        // Initialize the frequency array by decreasing counts for letters in p 
        // and increasing counts for the first 'lp' letters in s
        for (int i = 0; i < lp; i++) {
            freq[p.charAt(i) - 'a']--; // Decrease for p
            freq[s.charAt(i) - 'a']++; // Increase for s
        }
        
        // If all frequencies are zero, it means the first 'lp' characters in s form an anagram of p
        if (allZero(freq)) res.add(0);
        
        // Sliding window approach to check anagrams in the rest of the string
        for (int i = lp; i < ls; i++) {
            // Include the next character in the window
            freq[s.charAt(i) - 'a']++;
            
            // Remove the character that is sliding out of the window
            freq[s.charAt(i - lp) - 'a']--;
            
            // If all frequencies are zero, it means we found another anagram
            if (allZero(freq)) res.add(i - lp + 1);
        }
        
        return res;
    }

    // Helper method to check if all elements in the frequency array are zero
    private boolean allZero(int[] freq) {
        for (int i : freq) {
            if (i != 0) return false; // If any value is nonzero, return false
        }
        return true; // If all values are zero, return true
    }
}