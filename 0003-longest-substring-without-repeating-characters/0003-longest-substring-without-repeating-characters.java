// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> charIndexMap = new HashMap<>();
//         int maxLength = 0;
//         int left = 0;

//         for (int right = 0; right < s.length(); right++) {
//             char currentChar = s.charAt(right);
//             if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
//                 left = charIndexMap.get(currentChar) + 1;
//             }
//             charIndexMap.put(currentChar, right);
//             maxLength = Math.max(maxLength, right - left + 1);
//         }

//         return maxLength;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0;
        
        int[] index = new int[128]; // Assuming ASCII characters

        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (index[ch] != 0) {
                j = Math.max(j, index[ch]);
            }
            index[ch] = i + 1; // Store the index + 1 to differentiate from default 0
            l = Math.max(l, i - j + 1);
        }
        return l;
    }
}