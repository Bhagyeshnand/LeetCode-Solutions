class Solution {
    public int maxDistance(String st, int k) {
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;

        int result = 0;
        char[] chars = st.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'N') {
                n++;
            } else if (c == 'S') {
                s++;
            } else if (c == 'E') {
                e++;
            } else {
                w++;
            }

            int current = Math.abs(n-s) + Math.abs(e-w);
            int distance = current + Math.min(2*k,i+1-current);
            result = Math.max(result, distance);
        }

        return result;
    }
}