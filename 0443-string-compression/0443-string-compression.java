class Solution {
    public int compress(char[] ch) {
        int n = ch.length;

        int index = 0;
        int i = 0;

        while( i < n){
            char curr = ch[i];
            int count = 0;

            // find count of duplicates
            while(i < n && ch[i] == curr){
                count++;
                i++;
            }

            ch[index] = curr;
            index++;

            if(count > 1){
               String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    ch[index++] = c;
            }
            }
        }
        return index;
    }
}