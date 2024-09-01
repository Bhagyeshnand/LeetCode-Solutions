class Solution {
    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        String ans = "";
        
        for (String s : arr) {
            int n = s.length();
            if (n == 1 || n == 2) {
                ans += s.toLowerCase() + " ";
            } else {
                s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
                ans += s + " ";
            }
        }
        
        return ans.trim();
    }
}
