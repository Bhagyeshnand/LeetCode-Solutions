class Solution {
    public int findTheLongestSubstring(String s) {
         Map<String, Integer> mp = new HashMap<>();
        
        // Initialize an array to track the count of each vowel
        int[] vowelCount = new int[5]; // Count of 'a', 'e', 'i', 'o', 'u'

        String currentState = "00000";  // Initial state where all vowels have even counts
        mp.put(currentState, -1);
        
        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Update count for the vowel encountered
            if (s.charAt(i) == 'a')      vowelCount[0] = (vowelCount[0] + 1) % 2;
            else if (s.charAt(i) == 'e') vowelCount[1] = (vowelCount[1] + 1) % 2;
            else if (s.charAt(i) == 'i') vowelCount[2] = (vowelCount[2] + 1) % 2;
            else if (s.charAt(i) == 'o') vowelCount[3] = (vowelCount[3] + 1) % 2;
            else if (s.charAt(i) == 'u') vowelCount[4] = (vowelCount[4] + 1) % 2;

            // Create a string representing the current parity state of vowels
            currentState = "";
            for (int j = 0; j < 5; ++j) {
                currentState += vowelCount[j];
            }

            // Check if we've seen this state before
            if (mp.containsKey(currentState)) {
                // Calculate the length of the substring
                maxLength = Math.max(maxLength, i - mp.get(currentState));
            } else {
                // Store the first occurrence of this state
                mp.put(currentState, i);
            }
        }

        return maxLength;
    }
}