class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char ch[] = dominoes.toCharArray();
        int i = 0;
        while( i < n) {
            if(ch[i] != '.') {
                i++;
                continue;
            }
            int j = i; 
            while( j < n && ch[j] == '.')
                j++;
            if(i-1 >= 0 && j < n) {
                if(ch[i-1] == ch[j]) {
                    int k = i;
                    while(k < j)
                        ch[k++] = ch[i-1];
                } else {
                    if(ch[i-1] == 'R') {
                        int u = i, v = j-1;
                        while(u < v) {
                            ch[u++] = 'R';
                            ch[v--] = 'L';
                        }
                    }
                }
            } else if(i-1 >= 0) {
                if(ch[i-1] == 'R') {
                    int k = i;
                    while(k < j)
                        ch[k++] = 'R';
                }
            } else if(j < n) {
                if(ch[j] == 'L') {
                    int k = i;
                    while(k < j)
                        ch[k++] = 'L';
                }
            }
            i = j;
        }
        return String.valueOf(ch);
    }
}