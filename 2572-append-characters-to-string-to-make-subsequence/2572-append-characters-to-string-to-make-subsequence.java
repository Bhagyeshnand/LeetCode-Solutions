public class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;  // Start both pointers at the beginning of s and t
        
        while (i < s.length() && j < t.length()) {  // Continue until one of the strings is fully scanned
            if (s.charAt(i) == t.charAt(j)) {  // If characters match
                j++;  // Move the pointer in t forward
            }
            i++;  // Always move the pointer in s forward
        }
        
        return t.length() - j;  // The number of characters in t not matched in s
    }
}