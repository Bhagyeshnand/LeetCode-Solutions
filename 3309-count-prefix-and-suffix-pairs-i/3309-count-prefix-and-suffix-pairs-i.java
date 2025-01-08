class Solution {
    public boolean isPrefixAndSuffix(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for(int i = 0; i< w1.length; i++){
            if(w1[i] != w2[i]) return false;
            if(w1[i] != w2[w2.length - w1.length + i]) return false;
        }
        return true;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i< words.length; i++){
            String word1 = words[i];

            for(int j = i+1; j<words.length; j++){
                String word2 = words[j];
                if(word1.length() > word2.length() ){
                    continue;
                }

                if(isPrefixAndSuffix(word1, word2)){
                    count++;
                }
            }
        }
        return count;
    }
}