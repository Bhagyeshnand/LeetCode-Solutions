class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String cleaned = s.replace("-", "").toUpperCase();

        StringBuilder sb = new StringBuilder(cleaned);

        for(int i = sb.length() - k; i >0; i-=k){
            sb.insert(i, "-");
        }
        return sb.toString();
    }
}