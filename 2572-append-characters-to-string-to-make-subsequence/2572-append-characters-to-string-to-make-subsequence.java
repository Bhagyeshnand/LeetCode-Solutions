class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                return 0;
        }
        return n - j;
        
    }
}

/*
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
*/
