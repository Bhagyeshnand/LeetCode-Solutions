class Solution {
    public int canBeTypedWords(String text, String b) {
        int count = 0;
        String[] arr = text.split("\\s+");
        
        for (String s : arr) {
            boolean canBeTyped = true;
            for (char c : s.toCharArray()) {
                if (b.indexOf(c) != -1) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped) {
                count++;
            }
        }
        
        return count;
    }
}