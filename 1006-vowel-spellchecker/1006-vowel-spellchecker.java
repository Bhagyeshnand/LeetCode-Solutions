class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int m = wordlist.length, n = queries.length;
        String[] res = new String[n];
        Map<String, Integer> caseSense = new HashMap<>();
        Map<String, Integer> caseInsense = new HashMap<>();
        Map<String, Integer> vowelErrors = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            String word = wordlist[i];
            caseSense.put(word, i);
            String lowerCase = word.toLowerCase();
            char[] vowelRepArr = lowerCase.toCharArray();
            for (int j = 0; j < vowelRepArr.length; j++) {
                if (vowelRepArr[j] == 'e' || vowelRepArr[j] == 'i' || vowelRepArr[j] == 'o' || vowelRepArr[j] == 'u') {
                    vowelRepArr[j] = 'a';
                }
            }
            caseInsense.put(lowerCase, i);
            vowelErrors.put(new String(vowelRepArr), i);
        }
        for (int i = 0; i < n; i++) {
            String word = queries[i];
            if (caseSense.containsKey(word)) {
                res[i] = word;
                continue;
            }

            String lowerCase = word.toLowerCase();
            if (caseInsense.containsKey(lowerCase)) {
                res[i] = wordlist[caseInsense.get(lowerCase)];
                continue;
            }

            char[] vowelRepArr = lowerCase.toCharArray();
            for (int j = 0; j < vowelRepArr.length; j++) {
                if (vowelRepArr[j] == 'e' || vowelRepArr[j] == 'i' || vowelRepArr[j] == 'o' || vowelRepArr[j] == 'u') {
                    vowelRepArr[j] = 'a';
                }
            }
            String vowelRepStr = new String(vowelRepArr);
            if (vowelErrors.containsKey(vowelRepStr)) {
                res[i] = wordlist[vowelErrors.get(vowelRepStr)];
                continue;
            }
            res[i] = "";
        }

        return res;

    }
}